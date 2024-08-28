package io.github.orionlibs.orion_llm4j_inference.core.tensor;

import io.github.orionlibs.orion_llm4j_inference.core.gguf.GGUFType;
import io.github.orionlibs.orion_llm4j_inference.core.utils.AggregateFunction;
import io.github.orionlibs.orion_llm4j_inference.core.utils.MapFunction;
import io.github.orionlibs.orion_llm4j_inference.core.utils.MapWithIndexFunction;
import java.util.Arrays;
import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorSpecies;

public interface FloatTensor
{
    static int numberOfElements(int... dimensions)
    {
        assert Arrays.stream(dimensions).allMatch(i -> i > 0);
        return Arrays.stream(dimensions).reduce(Math::multiplyExact).orElseThrow();
    }


    int size();


    float getFloat(int index);


    void setFloat(int index, float value);


    FloatVector getFloatVector(VectorSpecies<Float> species, int offset);


    GGUFType type();


    float scalarDot(FloatTensor thiz, int thisOffset, FloatTensor that, int thatOffset, int size);


    float dot(int thisOffset, FloatTensor that, int thatOffset, int size);


    void matmul(FloatTensor that, FloatTensor out, int dim0, int dim1);


    float reduce(int thisOffset, int size, float seed, AggregateFunction reduce);


    float sum(int thisOffset, int size);


    float max(int thisOffset, int size);


    void copyTo(int thisOffset, FloatTensor that, int thatOffset, int size);


    int argmax(int thisOffset, int size);


    int argmax();


    FloatTensor mapInPlace(int thisOffset, int size, MapFunction mapFunction);


    FloatTensor mapInPlace(MapFunction mapFunction);


    FloatTensor mapWithIndexInPlace(int thisOffset, int size, MapWithIndexFunction mapWithIndexFunction);


    FloatTensor addInPlace(int thisOffset, FloatTensor that, int thatOffset, int size);


    FloatTensor addInPlace(FloatTensor that);


    FloatTensor multiplyInPlace(int thisOffset, FloatTensor that, int thatOffset, int size);


    FloatTensor multiplyInPlace(FloatTensor that);


    FloatTensor divideInPlace(int thisOffset, int size, float value);


    FloatTensor fillInPlace(int thisOffset, int size, float value);


    FloatTensor softmaxInPlace(int thisOffset, int size);


    FloatTensor saxpyInPlace(int thisOffset, FloatTensor that, int thatOffset, int size, float a);
}
