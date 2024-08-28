package io.github.orionlibs.orion_llm4j_inference.core.sampler;

import io.github.orionlibs.orion_llm4j_inference.core.tensor.FloatTensor;

@FunctionalInterface
public interface Sampler
{
    int sampleToken(FloatTensor logits);


    Sampler ARGMAX = FloatTensor::argmax;
}
