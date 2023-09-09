package com.stepik.course;

import java.util.Scanner;
import java.util.Stack;

public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.close();
        Fibonacci f = new Fibonacci();
        f.FibonacciArray(n);
    }

    private void StackMethod() {
        Stack<String> stack = new Stack<String>();
        stack.push("Minecraft");
        stack.push("Forza");
        stack.push("GTA");
        stack.push("Brawl Stars");

        System.out.println("Is stack empty? : " + stack.empty());
    }
}