package io.github.orionlibs.orion_llm4j_inference.core.utils;

@FunctionalInterface
public interface AggregateFunction
{
    float apply(float acc, float value);
}
