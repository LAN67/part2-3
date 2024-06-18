package ru.part2;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class State {
    private Map<Method, Object> state = new HashMap<>();

    public State() {
    }

    public void putVal(Method key, Object val) {
        state.put(key, val);
    }

    public int hashCode() {
        int hash = 0;
        for (Map.Entry<Method, Object> one: this.state.entrySet()){
            hash += Objects.hash(one.getKey(), Arrays.toString((Object[])one.getValue()));
            hash *=7;
        }
        return hash;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final State other = (State) obj;
        if(other.state.size() != this.state.size()) return false;
        for (Method key : other.state.keySet()) {
            if (this.state.containsKey(key)) {
                if (!Arrays.equals((Object[]) other.state.get(key), (Object[])this.state.get(key))) return false;
            }else{
                return false;
            }
        }
        return true;
    }
}
