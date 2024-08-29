package io.github.orionlibs.orion_llm4j_inference.core;

import io.github.orionlibs.orion_llm4j_inference.core.sampler.Sampler;
import java.util.List;
import java.util.Set;
import java.util.function.IntConsumer;

public abstract class LLMProcessor
{
    protected Configuration configuration;
    protected Tokenizer tokenizer;
    protected Weights weights;


    public LLMProcessor(Configuration configuration, Tokenizer tokenizer, Weights weights)
    {
        this.configuration = configuration;
        this.tokenizer = tokenizer;
        this.weights = weights;
    }


    public abstract Response generateTokens(LLMProcessor model, State state, int startPosition, List<Integer> promptTokens, Set<Integer> stopTokens, int maxTokens, Sampler sampler,
                    IntConsumer onTokenGenerated);


    public Configuration getConfiguration()
    {
        return configuration;
    }


    public Weights getWeights()
    {
        return weights;
    }


    public Tokenizer getTokenizer()
    {
        return tokenizer;
    }
}
