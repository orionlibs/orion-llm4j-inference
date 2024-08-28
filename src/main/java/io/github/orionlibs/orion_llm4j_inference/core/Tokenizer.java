package io.github.orionlibs.orion_llm4j_inference.core;

import io.github.orionlibs.orion_llm4j_inference.core.utils.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HexFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Tokenizer
{
    static String replaceControlCharacters(int[] codePoints)
    {
        // we don't want to print control characters
        // which distort the output (e.g. \n or much worse)
        // https://stackoverflow.com/questions/4324790/removing-control-characters-from-a-string-in-python/19016117#19016117
        // http://www.unicode.org/reports/tr44/#GC_Values_Table\
        StringBuilder chars = new StringBuilder();
        for(int cp : codePoints)
        {
            if(Character.getType(cp) == Character.CONTROL && cp != '\n')
            {
                chars.append("\\u").append(HexFormat.of().toHexDigits(cp, 4)); // escape
            }
            else
            {
                chars.appendCodePoint(cp); // this character is ok
            }
        }
        return chars.toString();
    }


    static String replaceControlCharacters(String str)
    {
        return replaceControlCharacters(str.codePoints().toArray());
    }


    static List<String> findAll(Pattern pattern, String text)
    {
        List<String> allMatches = new ArrayList<>();
        Matcher matcher = pattern.matcher(text);
        while(matcher.find())
        {
            allMatches.add(matcher.group());
        }
        return allMatches;
    }


    static Map<Integer, Integer> bytesToUnicode()
    {
        List<Integer> bs = new ArrayList<>();
        IntStream.rangeClosed('!', '~').forEach(bs::add);
        IntStream.rangeClosed('¡', '¬').forEach(bs::add);
        IntStream.rangeClosed('®', 'ÿ').forEach(bs::add);
        List<Integer> cs = new ArrayList<>(bs);
        int n = 0;
        for(int b = 0; b < 256; ++b)
        {
            if(!bs.contains(b))
            {
                bs.add(b);
                cs.add(256 + n);
                n += 1;
            }
        }
        // return dict(zip(bs, cs))
        return IntStream.range(0, bs.size())
                        .boxed()
                        .collect(Collectors.toMap(bs::get, cs::get));
    }


    String regexPattern();


    Map<String, Integer> getSpecialTokens();


    boolean isSpecialToken(int tokenIndex);


    private int[] encodeImpl(String text)
    {
        return encode(text, Set.of()).stream().mapToInt(i -> i).toArray();
    }


    List<Integer> encode(String text, Set<String> allowedSpecial);


    List<Integer> encodeOrdinary(String text);


    private Map<Pair<Integer, Integer>, Integer> getStats(List<Integer> ids)
    {
        Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        for(int i = 0; i + 1 < ids.size(); i++)
        {
            Pair<Integer, Integer> key = new Pair<>(ids.get(i), ids.get(i + 1));
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return map;
    }


    List<Integer> encodeChunk(String chunk);


    List<Integer> merge(List<Integer> ids, Pair<Integer, Integer> pair, int idx);


    String decodeImpl(List<Integer> tokens);


    int[] encode(String text);


    List<Integer> encodeAsList(String text);


    String decode(List<Integer> tokens);
}
