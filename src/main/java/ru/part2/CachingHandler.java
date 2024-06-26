package ru.part2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CachingHandler<T> implements InvocationHandler {
    private T currentObject;
    private State state = new State();
    private Map<State, Value> results = new ConcurrentHashMap<>();
    private int sizeCache; //максимальный размер кэша в node

    public CachingHandler(T currentObject, int sizeCache) {
        this.currentObject = currentObject;
        this.sizeCache = sizeCache;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object objectResult;
        Method currentMethod;
        int delayCache = 0;
        Value value;

        currentMethod = currentObject.getClass().getMethod(method.getName(), method.getParameterTypes());
        if (currentMethod.isAnnotationPresent(Mutator.class)) {
            state.putVal(currentMethod.getName(), args);
        }
        if (currentMethod.isAnnotationPresent(Cache.class)) {
            delayCache = currentMethod.getAnnotation(Cache.class).value();
            state.setMethod(currentMethod.getName());
            value = results.get(state);
            if (value != null) {
                if (delayCache != 0) {
                    value.setTimerClear(System.currentTimeMillis() + delayCache); // устанавливаем timerClear
                    results.put(state, value); // обновляем timerClear
                }
                return value.getVal();
            } else {
                objectResult = method.invoke(currentObject, args);
                results.put(new State(state), new Value(objectResult, delayCache == 0 ? 0 : System.currentTimeMillis() + delayCache));
                if (results.size() > sizeCache && delayCache != 0) {
                    new ClearCache().start();
                }
                return objectResult;
            }
        }
        return method.invoke(currentObject, args);
    }

    //очистка кэша
    public class ClearCache extends Thread {
        @Override
        public void run() {
            //System.out.println("=============== clear cache ===============");
            //System.out.println(results.size());
            results.forEach((k, v) -> {
                if (v.getTimerClear() <= System.currentTimeMillis()) results.remove(k);
            });
            //System.out.println(results.size());
        }
    }
}