package io.github.orionlibs.orion_llm4j_inference.core.io;

import io.github.orionlibs.orion_llm4j_inference.options.Role;

public record LLMRequest(Role role, String content)
{
}
