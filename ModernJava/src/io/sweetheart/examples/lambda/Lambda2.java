package io.sweetheart.examples.lambda;

public class Lambda2 {
    @FunctionalInterface
    public static interface Converter<F, T> {
        T convert(F from);
    }
}
