package io.github.orionlibs.orion_llm4j_inference.core;

import io.github.orionlibs.orion_llm4j_inference.core.sampler.Sampler;
import java.util.List;
import java.util.Set;
import java.util.function.IntConsumer;

public abstract class TokenGenerator
{
    private LLMConfiguration configuration;


    public TokenGenerator(LLMConfiguration configuration)
    {
        this.configuration = configuration;
    }


    public abstract Response generateTokens(TokenGenerationState state, int startPosition, List<Integer> promptTokens, Set<Integer> stopTokens, int maxTokens, Sampler sampler, IntConsumer onTokenGenerated);


    public LLMConfiguration getConfiguration()
    {
        return configuration;
    }
}
