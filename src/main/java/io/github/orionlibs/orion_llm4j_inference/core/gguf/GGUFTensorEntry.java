package io.github.orionlibs.orion_llm4j_inference.core.gguf;

import java.lang.foreign.MemorySegment;

public record GGUFTensorEntry(MemorySegment mappedFile, String name, GGUFType ggmlType, int[] shape,
                              MemorySegment memorySegment)
{
}
