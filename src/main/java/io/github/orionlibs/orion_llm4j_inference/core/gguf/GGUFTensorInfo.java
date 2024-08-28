package io.github.orionlibs.orion_llm4j_inference.core.gguf;

public record GGUFTensorInfo(String name, int[] dimensions, GGUFType ggmlType, long offset)
{
}
