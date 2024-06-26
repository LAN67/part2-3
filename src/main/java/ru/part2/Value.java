package ru.part2;

import lombok.Getter;
import lombok.Setter;

public class Value {

    @Setter
    @Getter
    public Object val;
    @Setter
    @Getter
    public long timerClear = 0; //время очистки значения в миллисекундах

    public Value(Object val, long timerClear) {
        this.val = val;
        this.timerClear = timerClear;
    }
}
