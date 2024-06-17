package ru.part2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== num=1, denum=3");
        Fractionable f1 = Utils.cache(new Fraction(0,0));
        f1.setNum(1);
        f1.setDenum(3);
        System.out.println("count=" + f1.getCountTest());
        System.out.println("===");
        System.out.println(f1.doubleValue());
        System.out.println("count=" + f1.getCountTest());
        System.out.println(f1.doubleValue());
        System.out.println("count=" + f1.getCountTest());
        System.out.println(f1.doubleValue());
        System.out.println("count=" + f1.getCountTest());
        System.out.println(f1.doubleValue());
        System.out.println("count=" + f1.getCountTest());

        System.out.println("=== denum=4");
        f1.setDenum(4);
        System.out.println("count=" + f1.getCountTest());
        System.out.println("===");
        System.out.println(f1.doubleValue());
        System.out.println("count=" + f1.getCountTest());
        System.out.println(f1.doubleValue());
        System.out.println("count=" + f1.getCountTest());
        System.out.println(f1.doubleValue());
        System.out.println("count=" + f1.getCountTest());
        System.out.println(f1.doubleValue());
        System.out.println("count=" + f1.getCountTest());
        System.out.println(f1.doubleValue());
        System.out.println("count=" + f1.getCountTest());
        System.out.println(f1.doubleValue());
        System.out.println("count=" + f1.getCountTest());

        System.out.println("=== denum=3");
        f1.setDenum(3);
        System.out.println("count=" + f1.getCountTest());
        System.out.println("===");
        System.out.println(f1.doubleValue());
        System.out.println("count=" + f1.getCountTest());
        System.out.println(f1.doubleValue());
        System.out.println("count=" + f1.getCountTest());
        System.out.println(f1.doubleValue());
        System.out.println("count=" + f1.getCountTest());
        System.out.println(f1.doubleValue());
        System.out.println("count=" + f1.getCountTest());
        System.out.println(f1.doubleValue());
        System.out.println("count=" + f1.getCountTest());
        System.out.println(f1.doubleValue());
        System.out.println("count=" + f1.getCountTest());

        System.out.println("==== sleep");
        Thread.sleep(2000);
        System.out.println("count=" + f1.getCountTest());
        System.out.println(f1.doubleValue());
        System.out.println("count=" + f1.getCountTest());
        System.out.println(f1.doubleValue());
        System.out.println("count=" + f1.getCountTest());
        System.out.println(f1.doubleValue());
        System.out.println("count=" + f1.getCountTest());
        System.out.println(f1.doubleValue());
        System.out.println("count=" + f1.getCountTest());
        System.out.println(f1.doubleValue());
        System.out.println("count=" + f1.getCountTest());
        System.out.println(f1.doubleValue());
        System.out.println("count=" + f1.getCountTest());
    }
}
