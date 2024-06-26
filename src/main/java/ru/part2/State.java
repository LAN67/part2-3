package ru.part2;

import lombok.Setter;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class State {
    Map<String, Object> state = new HashMap<>();
    @Setter
    String method;

    public State() {
    }

    public State(State st){
        this.state = new HashMap<>(st.state);
        this.method = st.method;
    }

    public void putVal(String key, Object val) {
        state.put(key, val);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hash(this.method);
        for (Map.Entry<String, Object> one: this.state.entrySet()){
            hash += Objects.hash(one.getKey(), Arrays.toString((Object[])one.getValue()));
            hash *=7;
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final State other = (State) obj;
        if(other.state.size() != this.state.size()) return false;
        for (String key : other.state.keySet()) {
            if (this.state.containsKey(key)) {
                if (!Arrays.equals((Object[]) other.state.get(key), (Object[])this.state.get(key))) return false;
            }else{
                return false;
            }
        }
        if(other.method == null) return false;
        if(!this.method.equals(other.method)) return false;
        return true;
    }
}
