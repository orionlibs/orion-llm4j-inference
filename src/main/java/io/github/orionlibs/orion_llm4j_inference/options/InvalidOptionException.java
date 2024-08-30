package io.github.orionlibs.orion_llm4j_inference.options;

import io.github.orionlibs.orion_assert.OrionUncheckedException;

public class InvalidOptionException extends OrionUncheckedException
{
    private static final String DefaultErrorMessage = "The given option is invalid.";


    public InvalidOptionException()
    {
        super(DefaultErrorMessage);
    }


    public InvalidOptionException(String message)
    {
        super(message);
    }


    public InvalidOptionException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public InvalidOptionException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public InvalidOptionException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}