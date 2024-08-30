package io.github.orionlibs.orion_llm4j_inference.core.encoder;

import io.github.orionlibs.orion_llm4j_inference.core.InputMessageForLLM;
import java.util.List;

public interface MessageEncoder
{
    List<Integer> encodeMessage(InputMessageForLLM message);
}
