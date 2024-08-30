package io.github.orionlibs.orion_llm4j_inference.core.token;

import io.github.orionlibs.orion_llm4j_inference.core.LLMConfiguration;
import io.github.orionlibs.orion_llm4j_inference.core.io.LLMResponse;
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


    public abstract LLMResponse generateTokens(TokenGenerationState state, int startPosition, List<Integer> promptTokens, Set<Integer> stopTokens, int maxTokens, Sampler sampler, IntConsumer onTokenGenerated);


    public LLMConfiguration getConfiguration()
    {
        return configuration;
    }
}
