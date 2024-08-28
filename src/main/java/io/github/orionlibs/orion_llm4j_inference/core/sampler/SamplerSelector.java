package io.github.orionlibs.orion_llm4j_inference.core.sampler;

public interface SamplerSelector
{
    Sampler selectSampler(int vocabularySize, float temperature, float topp);
}