package com.stepik.courses.methods.fibonacci;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YetSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger n = scanner.nextBigInteger();
        int m = scanner.nextInt();
        scanner.close();

        List<BigInteger> periodList = new ArrayList<>();

        periodList.add(BigInteger.ZERO);
        periodList.add(BigInteger.ONE);

        for (int i = 2; i < m * 6; i++) {
            periodList.add(i, (periodList.get(i - 2).add(periodList.get(i - 1))).mod(BigInteger.valueOf(m)));
            if (periodList.get(i).equals(BigInteger.ONE) && periodList.get(i - 1).equals(BigInteger.ZERO)) {
                int period = i - 1;
                BigInteger remainder = n.mod(BigInteger.valueOf(period));
                System.out.println(periodList.get(remainder.intValue()));
                return;
            }
        }

        System.out.println(periodList.get(n.mod(BigInteger.valueOf(6 * m)).intValue()));
    }
}
