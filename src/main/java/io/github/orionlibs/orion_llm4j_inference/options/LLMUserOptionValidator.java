package io.github.orionlibs.orion_llm4j_inference.options;

public interface LLMUserOptionValidator<T>
{
    boolean isValid(LLMOptions options, T optionToCheck);


    boolean isValid(T optionToCheck);


    void isValidWithException(LLMOptions options, T optionToCheck) throws InvalidOptionException;


    void isValidWithException(T optionToCheck) throws InvalidOptionException;
}