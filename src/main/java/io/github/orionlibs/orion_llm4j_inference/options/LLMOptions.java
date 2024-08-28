package io.github.orionlibs.orion_llm4j_inference.options;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public final class LLMOptions
{
    private final Map<String, Object> options;
    private Map<String, Object> oldOptions;
    public boolean haveOptionsChanged;


    public LLMOptions()
    {
        this.options = new HashMap<>();
    }


    public LLMOptions(final Map<String, Object> options)
    {
        this.options = options;
    }


    public void add(final String key, Object value)
    {
        oldOptions = Map.copyOf(options);
        options.put(key, value);
        haveOptionsChanged = !oldOptions.equals(options);
    }


    public void add(final Map<String, Object> optionsToAdd)
    {
        oldOptions = Map.copyOf(options);
        options.putAll(optionsToAdd);
        haveOptionsChanged = !oldOptions.equals(options);
    }


    public Object getOptionValue(String key)
    {
        return options.get(key);
    }
}