package ru.part2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class CachingHandler<T> implements InvocationHandler {
    private T currentObject;
    private Map<Method, Object> results = new HashMap<>();

    private Timer timer;
    private boolean timerRun = false;

    public CachingHandler(T currentObject) {
        this.currentObject = currentObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object objectResult;
        Method currentMethod;
        int delayCache = 0;

        currentMethod = currentObject.getClass().getMethod(method.getName(), method.getParameterTypes());
        if (currentMethod.isAnnotationPresent(Mutator.class)) {
            clearCache();
        }
        if (currentMethod.isAnnotationPresent(Cache.class)) {
            delayCache = currentMethod.getAnnotation(Cache.class).value();
            if (delayCache > 0) {
                //создаем таймер
                timerStop();
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    {
                        timerRun = true;
                    }

                    public void run() {
                        clearCache();
                    }
                }, delayCache);
            }
            if (results.containsKey(currentMethod)) {
                return results.get(currentMethod);
            }
            objectResult = method.invoke(currentObject, args);
            results.put(currentMethod, objectResult);
            return objectResult;
        }
        return method.invoke(currentObject, args);
    }

    //очистка кэша
    private void clearCache() {
        timerStop();
        results.clear();
    }

    //останавливаем таймер
    private void timerStop() {
        if (timerRun) {
            timer.cancel();
            timer.purge();
            timer = null;
            timerRun = false;
        }
    }
}
