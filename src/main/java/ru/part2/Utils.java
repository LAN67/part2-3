package ru.part2;

import java.lang.reflect.Proxy;

public class Utils {
    public static <T> T cache(T objectIncome, int sizeCache) {
        return (T) Proxy.newProxyInstance(
                objectIncome.getClass().getClassLoader(),
                objectIncome.getClass().getInterfaces(),
                new CachingHandler(objectIncome, sizeCache));
    }
}
