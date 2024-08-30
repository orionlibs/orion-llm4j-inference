package io.github.orionlibs.orion_llm4j_inference.core;

import io.github.orionlibs.orion_llm4j_inference.core.utils.Pair;
import java.util.List;

public interface Tokenizer extends SpecialTokens, TokenEncoder, TokenDecoder
{
    List<Integer> getTokenIDs(String chunk);


    List<Integer> mergeTokens(List<Integer> ids, Pair<Integer, Integer> pair, int idx);
}
