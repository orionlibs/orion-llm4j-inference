package io.github.orionlibs.orion_llm4j_inference.core;

import java.util.List;

public interface TokenDecoder
{
    String decodeTokens(List<Integer> tokens);


    String decode(List<Integer> tokens);
}
