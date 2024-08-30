package io.github.orionlibs.orion_llm4j_inference.core;

import io.github.orionlibs.orion_llm4j_inference.core.tensor.FloatTensor;

public interface NextTokenGenerator
{
    FloatTensor generate(LLMProcessor model, TokenGenerationState state, int token, int position);
}
