package io.github.orionlibs.orion_llm4j_inference.core.token;

import java.util.List;
import java.util.Set;

public interface TokenEncoder
{
    List<Integer> encodeSpecialTokens(String text, Set<String> allowedSpecial);


    int[] encodeSpecialTokens(String text);


    List<Integer> encodeOrdinaryTokens(String text);


    List<Integer> encodeAsList(String text);
}
