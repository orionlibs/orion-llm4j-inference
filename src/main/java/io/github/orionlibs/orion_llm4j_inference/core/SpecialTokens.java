package io.github.orionlibs.orion_llm4j_inference.core;

import java.util.Map;

public interface SpecialTokens
{
    Map<String, Integer> getSpecialTokens();


    boolean isSpecialToken(int tokenIndex);
}
