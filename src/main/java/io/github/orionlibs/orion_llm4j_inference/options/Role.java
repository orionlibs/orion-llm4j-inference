package io.github.orionlibs.orion_llm4j_inference.options;

public record Role(String name)
{
    public static Role SYSTEM = new Role("system");
    public static Role USER = new Role("user");
    public static Role ASSISTANT = new Role("assistant");


    @Override
    public String toString()
    {
        return name;
    }
}
