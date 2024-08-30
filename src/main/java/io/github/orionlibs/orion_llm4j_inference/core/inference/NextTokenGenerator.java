package io.github.orionlibs.orion_llm4j_inference.core.inference;

import io.github.orionlibs.orion_llm4j_inference.core.LLMProcessor;
import io.github.orionlibs.orion_llm4j_inference.core.tensor.FloatTensor;
import io.github.orionlibs.orion_llm4j_inference.core.token.TokenGenerationState;

public interface NextTokenGenerator
{
    FloatTensor generate(LLMProcessor model, TokenGenerationState state, int token, int position);
}
