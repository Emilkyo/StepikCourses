package com.stepik.courses.javaBasic;

public class Base {
    public static void main(String[] args) {
        int[] a1 = {0, 2, 2, 10, 10, 20};
        int[] a2 = {1, 3, 5, 7, 8, 10, 10};
        //int[] a1 = {-3, -2, -1, 0};
        //int[] a2 = {-1, 1, 1};
        int[] printArray = mergeArrays(a1, a2);
    }

    public static boolean isPalindrome(String text) {
        text = text.replaceAll("[^a-zA-Z0-9]", "");
        text = text.toUpperCase();
        int length = text.length() - 1;
        for (int i = 0; i < length; i++, length--) {
            if (text.charAt(i) != text.charAt(length))
                return false;
        }
        return true; // your implementation here
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int n = a1.length;
        int m = a2.length;
        int[] mergeArray = new int[n + m];
        int i = 0, k = 0, l = 0;
        while (k < n && l < m) {
            if (a1[k] < a2[l]) {
                mergeArray[i++] = a1[k++];
            } else {
                mergeArray[i++] = a2[l++];
            }
        }

        while (k < n) {
            mergeArray[i++] = a1[k++];
        }

        while (l < m) {
            mergeArray[i++] = a2[l++];
        }

        return mergeArray;
    }


    private String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder textPerRole = new StringBuilder();
        for (int i = 0; i < roles.length; i++) {
            textPerRole.append(roles[i]).append(": \n");
            for (int k = 0; k < textLines.length; k++) {
                if (textLines[k].startsWith(roles[i] + ": ")) {
                    textPerRole.append(k + 1).append(")");
                    textPerRole.append(textLines[k].substring(roles[i].length() + 1)).append("\n");
                }
            }
        }
        return textPerRole.toString();
    }
}




