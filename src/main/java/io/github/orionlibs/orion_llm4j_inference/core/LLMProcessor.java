package io.github.orionlibs.orion_llm4j_inference.core;

import io.github.orionlibs.orion_llm4j_inference.core.sampler.Sampler;
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
    public abstract Response generateTokens(TokenGenerationState state, int startPosition, List<Integer> promptTokens, Set<Integer> stopTokens, int maxTokens, Sampler sampler,
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
