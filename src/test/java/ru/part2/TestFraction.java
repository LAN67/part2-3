package ru.part2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFraction {

    @Test
    public void TestFractionCache() throws InterruptedException {
        Fractionable f1 = Utils.cache(new Fraction(0, 0));

        //ставим начальные значения num = 1 и denum = 2 (1/2=0.5)
        f1.setNum(1);
        f1.setDenum(2);
        Assertions.assertEquals(0, f1.getCountTest());
        Assertions.assertEquals(0.5, f1.doubleValue());
        Assertions.assertEquals(1, f1.getCountTest());
        Assertions.assertEquals(0.5, f1.doubleValue());
        Assertions.assertEquals(1, f1.getCountTest());

        //ставим denum = 4 (1/4=0.25)
        f1.setDenum(4);
        Assertions.assertEquals(0, f1.getCountTest());
        Assertions.assertEquals(0.25, f1.doubleValue());
        Assertions.assertEquals(1, f1.getCountTest());
        Assertions.assertEquals(0.25, f1.doubleValue());
        Assertions.assertEquals(1, f1.getCountTest());
        Assertions.assertEquals(0.25, f1.doubleValue());
        Assertions.assertEquals(1, f1.getCountTest());

        //ставим num = 8 (8/4=2)
        f1.setNum(8);
        Assertions.assertEquals(0, f1.getCountTest());
        Assertions.assertEquals(2, f1.doubleValue());
        Assertions.assertEquals(1, f1.getCountTest());
        Assertions.assertEquals(2, f1.doubleValue());
        Assertions.assertEquals(1, f1.getCountTest());
        Assertions.assertEquals(2, f1.doubleValue());
        Assertions.assertEquals(1, f1.getCountTest());

        //ставим начальные значения num = 9 и denum = 3 (9/3=3)
        f1.setNum(9);
        f1.setDenum(3);
        Assertions.assertEquals(0, f1.getCountTest());
        Assertions.assertEquals(3, f1.doubleValue());
        Assertions.assertEquals(1, f1.getCountTest());
        Assertions.assertEquals(3, f1.doubleValue());
        Assertions.assertEquals(1, f1.getCountTest());
        Assertions.assertEquals(3, f1.doubleValue());
        Assertions.assertEquals(1, f1.getCountTest());

        //ставим повторные значения num = 1 и denum = 2 (1/2=0.5)
        f1.setNum(1);
        f1.setDenum(2);
        Assertions.assertEquals(0, f1.getCountTest());
        Assertions.assertEquals(0.5, f1.doubleValue());
        Assertions.assertEquals(0, f1.getCountTest());
        Assertions.assertEquals(0.5, f1.doubleValue());
        Assertions.assertEquals(0, f1.getCountTest());
        Assertions.assertEquals(0.5, f1.doubleValue());
        Assertions.assertEquals(0, f1.getCountTest());

        //очистка кэша
        Thread.sleep(2000);
        Assertions.assertEquals(0, f1.getCountTest());
        Assertions.assertEquals(0.5, f1.doubleValue());
        Assertions.assertEquals(1, f1.getCountTest());
        Assertions.assertEquals(0.5, f1.doubleValue());
        Assertions.assertEquals(1, f1.getCountTest());
        Assertions.assertEquals(0.5, f1.doubleValue());
        Assertions.assertEquals(1, f1.getCountTest());
    }
}
