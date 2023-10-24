package com.stepik.courses.methods.fibonacci;

import java.math.BigInteger;
import java.util.Scanner;

public class GPTFindPeriodSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger n = scanner.nextBigInteger();
        int m = scanner.nextInt();
        scanner.close();

        BigInteger[] fibModM = new BigInteger[6 * m]; // The period cannot be longer than 6 * m
        fibModM[0] = BigInteger.ZERO;
        fibModM[1] = BigInteger.ONE;

        for (int i = 2; i < 6 * m; i++) {
            fibModM[i] = (fibModM[i - 1].add(fibModM[i - 2])).mod(BigInteger.valueOf(m));
            if (fibModM[i].equals(BigInteger.ONE) && fibModM[i - 1].equals(BigInteger.ZERO)) {
                int period = i - 1;
                BigInteger remainder = n.mod(BigInteger.valueOf(period));
                System.out.println(fibModM[remainder.intValue()]);
                return;
            }
        }

        // If we didn't find the period within 6*m iterations, just return the nth Fibonacci number modulo m
        System.out.println(fibModM[n.mod(BigInteger.valueOf(6 * m)).intValue()]);
    }
}
