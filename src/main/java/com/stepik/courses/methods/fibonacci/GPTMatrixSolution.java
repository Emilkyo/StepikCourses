package com.stepik.courses.methods.fibonacci;

import java.math.BigInteger;
import java.util.Scanner;

public class GPTMatrixSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger n = scanner.nextBigInteger();
        int m = scanner.nextInt();
        scanner.close();

        if (n.compareTo(BigInteger.ONE) <= 0) {
            System.out.println(n.mod(BigInteger.valueOf(m)));
        } else {
            // Look like
            // 1    1
            // 1    0
            BigInteger[][] matrix = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
            BigInteger[][] result = matrixPower(matrix, n.subtract(BigInteger.ONE), m);
            System.out.println(result[0][0].mod(BigInteger.valueOf(m)));
        }
    }

    public static BigInteger[][] matrixMultiply(BigInteger[][] A, BigInteger[][] B, int m) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;
        BigInteger[][] result = new BigInteger[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                result[i][j] = BigInteger.ZERO;
                for (int k = 0; k < colsA; k++) {
                    result[i][j] = result[i][j].add(A[i][k].multiply(B[k][j])).mod(BigInteger.valueOf(m));
                }
            }
        }

        return result;
    }

    public static BigInteger[][] matrixPower(BigInteger[][] matrix, BigInteger exponent, int m) {
        BigInteger[][] result = {{BigInteger.ONE, BigInteger.ZERO}, {BigInteger.ZERO, BigInteger.ONE}};

        while (exponent.compareTo(BigInteger.ZERO) > 0) {
            if (exponent.testBit(0)) {
                result = matrixMultiply(result, matrix, m);
            }
            matrix = matrixMultiply(matrix, matrix, m);
            exponent = exponent.shiftRight(1);
        }

        return result;
    }
}