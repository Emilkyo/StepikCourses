package com.stepik.courses.methods.greedyalgo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VariousTermsTest {
    String testNumber = null;

    @AfterEach
    void tearDown() {
        testNumber = null;
    }

    @Test
    void VariousTermsSixteenTest() {
        // Готовим фиктивные данные для ввода, заменяя стандартный ввод
        testNumber = "16";
        InputStream inputStream = new ByteArrayInputStream(testNumber.getBytes());
        System.setIn(inputStream);
        // Создаем объект Backpack с фиктивным вводом
        VariousTerms variousTerms = new VariousTerms();
        // Ожидаемый вывод
        String expectedOutput = "5\n1 2 3 4 6";
        System.out.println(variousTerms.toString());
        // Сравниваем ожидаемый вывод с фактическим выводом
        assertEquals(expectedOutput, variousTerms.toString());
    }

    @Test
    void VariousTermsSixTest() {
        // Готовим фиктивные данные для ввода, заменяя стандартный ввод
        testNumber = "6";
        InputStream inputStream = new ByteArrayInputStream(testNumber.getBytes());
        System.setIn(inputStream);
        // Создаем объект Backpack с фиктивным вводом
        VariousTerms variousTerms = new VariousTerms();
        // Ожидаемый вывод
        String expectedOutput = "3\n1 2 3";
        System.out.println(variousTerms.toString());
        // Сравниваем ожидаемый вывод с фактическим выводом
        assertEquals(expectedOutput, variousTerms.toString());
    }

    @Test
    void VariousTermsFourTest() {
        // Готовим фиктивные данные для ввода, заменяя стандартный ввод
        testNumber = "4";
        InputStream inputStream = new ByteArrayInputStream(testNumber.getBytes());
        System.setIn(inputStream);
        // Создаем объект Backpack с фиктивным вводом
        VariousTerms variousTerms = new VariousTerms();
        // Ожидаемый вывод
        String expectedOutput = "2\n1 3";
        System.out.println(variousTerms.toString());
        // Сравниваем ожидаемый вывод с фактическим выводом
        assertEquals(expectedOutput, variousTerms.toString());
    }

    @Test
    void VariousTermsTenTest() {
        // Готовим фиктивные данные для ввода, заменяя стандартный ввод
        testNumber = "10";
        InputStream inputStream = new ByteArrayInputStream(testNumber.getBytes());
        System.setIn(inputStream);
        // Создаем объект Backpack с фиктивным вводом
        VariousTerms variousTerms = new VariousTerms();
        // Ожидаемый вывод
        String expectedOutput = "4\n1 2 3 4";
        System.out.println(variousTerms.toString());
        // Сравниваем ожидаемый вывод с фактическим выводом
        assertEquals(expectedOutput, variousTerms.toString());
    }

    @Test
    void VariousTermsTwoTest() {
        // Готовим фиктивные данные для ввода, заменяя стандартный ввод
        testNumber = "2";
        InputStream inputStream = new ByteArrayInputStream(testNumber.getBytes());
        System.setIn(inputStream);
        // Создаем объект Backpack с фиктивным вводом
        VariousTerms variousTerms = new VariousTerms();
        // Ожидаемый вывод
        String expectedOutput = "1\n2";
        System.out.println(variousTerms.toString());
        // Сравниваем ожидаемый вывод с фактическим выводом
        assertEquals(expectedOutput, variousTerms.toString());
    }

    //Failed test #3 of 42. sum is 0, but should be 1
    @Test
    void VariousTermsOneTest() {
        // Готовим фиктивные данные для ввода, заменяя стандартный ввод
        testNumber = "1";
        InputStream inputStream = new ByteArrayInputStream(testNumber.getBytes());
        System.setIn(inputStream);
        // Создаем объект Backpack с фиктивным вводом
        VariousTerms variousTerms = new VariousTerms();
        // Ожидаемый вывод
        String expectedOutput = "1\n1";
        System.out.println(variousTerms.toString());
        // Сравниваем ожидаемый вывод с фактическим выводом
        assertEquals(expectedOutput, variousTerms.toString());
    }

    @Test
    void VariousTermsEightTest() {
        // Готовим фиктивные данные для ввода, заменяя стандартный ввод
        testNumber = "8";
        InputStream inputStream = new ByteArrayInputStream(testNumber.getBytes());
        System.setIn(inputStream);
        // Создаем объект Backpack с фиктивным вводом
        VariousTerms variousTerms = new VariousTerms();
        // Ожидаемый вывод
        String expectedOutput = "3\n1 2 5";
        System.out.println(variousTerms.toString());
        // Сравниваем ожидаемый вывод с фактическим выводом
        assertEquals(expectedOutput, variousTerms.toString());
    }

}