package io.github.orionlibs.orion_llm4j_inference.core;

import io.github.orionlibs.orion_llm4j_inference.core.inference.NextTokenGenerator;
import io.github.orionlibs.orion_llm4j_inference.core.io.LLMResponse;
import io.github.orionlibs.orion_llm4j_inference.core.model.Weights;
import io.github.orionlibs.orion_llm4j_inference.core.sampler.Sampler;
import io.github.orionlibs.orion_llm4j_inference.core.token.TokenGenerationState;
import io.github.orionlibs.orion_llm4j_inference.core.token.TokenGenerator;
import io.github.orionlibs.orion_llm4j_inference.core.token.Tokenizer;
import java.util.List;
import java.util.Set;
import java.util.function.IntConsumer;

public abstract class LLMProcessor extends TokenGenerator
{
    private Tokenizer tokenizer;
    private Weights weights;
    protected NextTokenGenerator nextTokenGenerator;


    public LLMProcessor(LLMConfiguration configuration, Tokenizer tokenizer, Weights weights, NextTokenGenerator nextTokenGenerator)
    {
        super(configuration);
        this.tokenizer = tokenizer;
        this.weights = weights;
        this.nextTokenGenerator = nextTokenGenerator;
    }


    @Override
    public abstract LLMResponse generateTokens(TokenGenerationState state, int startPosition, List<Integer> promptTokens, Set<Integer> stopTokens, int maxTokens, Sampler sampler,
                    IntConsumer onTokenGenerated);


    public Weights getWeights()
    {
        return weights;
    }


    public Tokenizer getTokenizer()
    {
        return tokenizer;
    }
}
