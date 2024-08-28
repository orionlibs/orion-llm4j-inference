package io.github.orionlibs.orion_llm4j_inference.core.sampler;

import java.util.Comparator;

public interface ToppSampler extends Sampler
{
    static void swap(int[] array, int from, int to)
    {
        int tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }


    void siftDown(int[] array, int from, int n, Comparator<Integer> comparator);
}
