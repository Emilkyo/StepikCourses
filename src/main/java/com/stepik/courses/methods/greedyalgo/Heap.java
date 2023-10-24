package com.stepik.courses.methods.greedyalgo;

import java.util.List;
import java.util.Scanner;

public class Heap {
    public Heap() {
        String str = "ex";
        int n = Integer.parseInt(str);
    }

    private int n;

    public void input() {
        Scanner scanner = new Scanner(System.in);
        Heap heap = new Heap();
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine().trim();

            if (input.startsWith("Insert ")) {
                // Разбираем команду "Insert x" и добавляем элемент x в кучу
                int value = Integer.parseInt(input.substring(7));
                insert(value);
            } else if (input.equals("ExtractMax")) {
                // Выполняем команду "ExtractMax" и выводим максимальный элемент
                int max = extractMax();
                System.out.println("Max: " + max);
            } else {
                // Неизвестная команда
                System.out.println("Unknown command: " + input);
            }
        }
        scanner.close();
    }

    private List<Integer> heap;


    private void insert(int value) {

    }

    private int extractMax() {
        return 0;
    }
}