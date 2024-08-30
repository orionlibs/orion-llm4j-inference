package io.github.orionlibs.orion_llm4j_inference.core;

import io.github.orionlibs.orion_llm4j_inference.options.Role;

public record InputMessageForLLM(Role role, String content)
{
}
