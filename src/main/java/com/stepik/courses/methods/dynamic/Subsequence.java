package com.stepik.courses.methods.dynamic;

// https://stepik.org/lesson/13257/step/5?unit=3442
public class Subsequence {

    public Subsequence() {

    }

    /* Алгоритм нахождения наибольшей возрастающей подпоследовательности.
     * Находит длину подпоследовательности
     */
    private int LISBottomUp(int[] array) {
        int n = array.length;
        int[] distance = new int[n];
        for (int i : distance) {
            distance[i] = 1;
            for (int j = 1; j < i - 1; j++) {
                if (array[j] < array[i] && distance[j + 1] > distance[i])
                    distance[i] = distance[j] + 1;
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, distance[i]);
        }
        return result;
    }

    /* *
     * .____________________________________________________________________.
     * | Алгоритм нахождения наибольшей возрастающей подпоследовательности. |
     * | Находит длину подпоследовательности и саму подпоследовательность   |
     * |____________________________________________________________________|
     * */
    private int LISBottomUp2(int[] array) {
        int n = array.length;
        int[] distance = new int[n];
        int[] prev = new int[n];
        for (int i : distance) {
            distance[i] = 1;
            prev[i] = -1;
            for (int j = 1; j < i - 1; j++) {
                if (array[j] < array[i] && distance[j + 1] > distance[i]) {
                    distance[i] = distance[j] + 1;
                    prev[i] = j;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, distance[i]);
        }
        return result;
    }

    // Восстановление ответа
    private void input(int result, int[] distance, int[] prev) {
        int[] indexes = new int[result]; // Индексы НВП
        //  Находим максимальное значение в расстоянии
        int k = 0;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] > distance[k])
                k = i;
        }

        int j = result;
        while (k > 0) {
            indexes[j] = k;
            j--;
            k = prev[k];
        }
    }
}
