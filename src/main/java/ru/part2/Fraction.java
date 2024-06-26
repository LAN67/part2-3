package ru.part2;

import java.util.Objects;

public class Fraction implements Fractionable{
    private int num;
    private int denum;
    int countTest = 0;

    public Fraction(int num, int denum) {
        this.num = num;
        this.denum = denum;
        countTest = 0;
    }

    @Mutator
    public void setNum(int num) {
        this.num = num;
        countTest = 0;
    }

    @Mutator
    public void setDenum(int denum) {
        this.denum = denum;
        countTest = 0;
    }

    @Cache(1500)
    public double doubleValue(){
        countTest++;
        return (double) num/denum;
    }

    @Override
    public int getCountTest() {
        return countTest;
    }
}
