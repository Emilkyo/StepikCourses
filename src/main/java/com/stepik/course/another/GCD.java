package com.stepik.course.another;

import java.util.Scanner;

public class GCD {
    //greatest common divisor
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        scanner.close();

        System.out.println(GCD(n, m));
    }

    public static int GCD(long a, long b) {
        if (a == 0)
            return (int) b;
        if (b == 0)
            return (int) a;
        if (a >= b)
            return GCD(a % b, b);
        else
            return GCD(a, b % a);
    }
}
