package ru.part2;

import lombok.Getter;

//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//import java.util.Arrays;

public class Utils {
    public static <T> T cache(T objectIncome) {
        return (T) Proxy.newProxyInstance(
                objectIncome.getClass().getClassLoader(),
                objectIncome.getClass().getInterfaces(),
                new CachingHandler(objectIncome));
    }
}
