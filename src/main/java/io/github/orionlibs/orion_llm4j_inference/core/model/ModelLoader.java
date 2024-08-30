package io.github.orionlibs.orion_llm4j_inference.core.model;

import io.github.orionlibs.orion_llm4j_inference.core.LLMProcessor;
import io.github.orionlibs.orion_llm4j_inference.core.token.Tokenizer;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public abstract class ModelLoader
{
    public abstract Vocabulary loadVocabulary(Map<String, Object> metadata);


    public abstract LLMProcessor loadModel(Path ggufPath, int contextLength) throws IOException;


    protected abstract Tokenizer createTokenizer(Map<String, Object> metadata, Vocabulary vocabulary);
}