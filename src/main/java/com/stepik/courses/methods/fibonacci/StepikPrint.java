package com.stepik.courses.methods.fibonacci;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StepikPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger n = scanner.nextBigInteger();
        int m = scanner.nextInt();
        scanner.close();

        List<BigInteger> period = findPeriod(n, m);
        int periodSize = period.size() - 2; // Из-за 0 и 1 в начале периода

        BigInteger remainder = BigInteger.valueOf(periodSize).compareTo(BigInteger.ZERO) == 0
                ? BigInteger.ZERO : n.mod(BigInteger.valueOf(periodSize));
        BigInteger result = period.get(remainder.intValue()); // Период начинается с 0


        System.out.println(result);
    }

    public static List<BigInteger> findPeriod(BigInteger n, int m) {
        List<BigInteger> periodList = new ArrayList<>();
        periodList.add(BigInteger.ZERO);
        periodList.add(BigInteger.ONE);

        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger next;

        for (int i = 2; i <= n.intValue() * 6; i++) {
            next = (a.add(b)).remainder(BigInteger.valueOf(m));
            periodList.add(next);

            a = b;
            b = next;

            if (next.equals(BigInteger.ONE) && a.equals(BigInteger.ZERO)) {
                break;
            }
        }

        return periodList;
    }
}
