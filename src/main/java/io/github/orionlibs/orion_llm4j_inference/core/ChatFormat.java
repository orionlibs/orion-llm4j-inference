package io.github.orionlibs.orion_llm4j_inference.core;

import io.github.orionlibs.orion_llm4j_inference.core.encoder.HeaderEncoder;
import io.github.orionlibs.orion_llm4j_inference.core.encoder.MessageEncoder;
import io.github.orionlibs.orion_llm4j_inference.core.token.Tokenizer;
import java.util.Set;

public abstract class ChatFormat implements MessageEncoder, HeaderEncoder
{
    protected final Tokenizer tokenizer;
    protected int beginOfText;


    public ChatFormat(Tokenizer tokenizer)
    {
        this.tokenizer = tokenizer;
    }


    public abstract Set<Integer> getStopTokens();


    public int getBeginOfText()
    {
        return beginOfText;
    }
}
