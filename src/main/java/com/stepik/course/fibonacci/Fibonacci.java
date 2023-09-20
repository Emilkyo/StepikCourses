package com.stepik.course.fibonacci;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    private int[] array;
    private int n;

    public Fibonacci(int n) {
        this.n = n;
        array = new int[n + 1];
        if (n > 0)
            array[1] = 1;
    }

    public List<Integer> periodList;

    public List<Integer> getPeriodList() {
        return periodList;
    }

    public int resultFibModulo;
    public List<BigInteger> fibList;

    public int getResultFibModulo() {
        return resultFibModulo;
    }

    public Fibonacci(long queue, Integer m) {
        fibList = new ArrayList<>();
        periodList = new ArrayList<>();
        findPeriod(queue, m);
        long periodIndex = queue % (periodList.size() - 2);
        resultFibModulo = getPeriodList().get((int) periodIndex);
    }

    public void findPeriod(long n, int m) {
        fibList.add(BigInteger.valueOf(0));
        fibList.add(BigInteger.valueOf(1));
        periodList.add(0);
        periodList.add(1);

        for (int i = 2; i < n; i++) {

            fibList.add(fibList.get(i - 2).add(fibList.get(i - 1)));
            BigInteger mod = fibList.get(i).remainder(BigInteger.valueOf(m));
            periodList.add(i, mod.intValue());

            //Найти цикл [0, 1 .... 0, 1]
            if (periodList.get(i) == 1 && periodList.get(i - 1) == 0) {
                break;
            }
        }
    }

    public int fibonacciArray() {

        for (int i = 2; i < n + 1; i++) {
            array[i] = array[i - 2] + array[i - 1];
        }
        return array[n];
    }

    public int lastFibDigit() {
        for (int i = 2; i < n + 1; i++) {
            array[i] = (array[i - 2] + array[i - 1]) % 10;
        }
        return array[n];
    }
}
