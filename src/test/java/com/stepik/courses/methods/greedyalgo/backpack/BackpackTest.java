package com.stepik.courses.methods.greedyalgo.backpack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackpackTest {
    private Input testInput;
    private String testString;

    @BeforeEach
    void setUp() {
        testInput = new Input();
    }


    @AfterEach
    void tearDown() {
        // Освобождаем ресурсы после каждого тестового метода
        testInput = null;
        testString = "";
    }

    @Test
    void testCalculate2() {
        // Готовим фиктивные данные для ввода, заменяя стандартный ввод
        testString = "5 10\n5 2\n3 4\n1 5\n8 8\n1 1";
        InputStream inputStream = new ByteArrayInputStream(testString.getBytes());
        System.setIn(inputStream);
        testInput = new Input();
        testInput.inputThingsList();
        // Создаем объект Backpack с фиктивным вводом
        Backpack backpack = new Backpack(testInput);

        // Запускаем метод Calculate
        backpack.Calculate();
        // Проверяем ожидаемый вывод, можно использовать вывод метода Calculate
        // и сравнить его с ожидаемым выводом
    }

    @Test
    void testCalculate() {
        testString = "5 9022\n3316 1601\n5375 8940\n2852 6912\n3336 9926\n1717 8427\n";
        InputStream inputStream = new ByteArrayInputStream(testString.getBytes());
        System.setIn(inputStream);
        testInput = new Input();
        testInput.inputThingsList();

        // Создаем объект Backpack с фиктивным вводом
        Backpack backpack = new Backpack(testInput);
        String result = backpack.Calculate();
        // Ожидаемый вывод
        String expectedOutput = "7777,731";

        String expectedBackpackListOutput = "[Item(cost=3316, weight=1601), Item(cost=5375, weight=8940), " +
                "Item(cost=2852, weight=6912), Item(cost=3336, weight=9926), Item(cost=1717, weight=8427)]";
        backpack.Calculate();

        // Сравниваем ожидаемый вывод с фактическим выводом
        assertEquals(expectedOutput, result);
    }

    @Test
    void backpackVolume6AndOneItem30() {
        testString = "1 6\n500 30\n";
        InputStream inputStream = new ByteArrayInputStream(testString.getBytes());
        System.setIn(inputStream);
        testInput = new Input();
        testInput.inputThingsList();

        Backpack backpack = new Backpack(testInput);
        String result = backpack.Calculate();
        String expectedBackpackListOutput = "[Item(cost=166.667, weight=9)]";
        String expectedOutput = "100,000";
        assertEquals(expectedOutput, result);
    }

    @Test
    void backpackGetItemListTest() {
        // Готовим фиктивные данные для ввода, заменяя стандартный ввод
        String testData = "3 10\n5 2\n3 4\n1 5\n";
        InputStream inputStream = new ByteArrayInputStream(testData.getBytes());
        System.setIn(inputStream);
        testInput = new Input();
        testInput.inputThingsList();
        // Создаем объект Backpack с фиктивным вводом
        Backpack backpack = new Backpack(testInput);
        // Ожидаемый вывод
        String expectedOutput = "[Item(cost=5, weight=2), Item(cost=3, weight=4), Item(cost=1, weight=5)]";
        // Сравниваем ожидаемый вывод с фактическим выводом
        assertEquals(expectedOutput, backpack.getThingsList().toString());
    }
}