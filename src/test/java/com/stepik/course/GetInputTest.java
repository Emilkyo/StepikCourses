package com.stepik.course;

import com.stepik.course.fibonacci.GetInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GetInputTest {
    private GetInput getInput;

    /**
     * {@code @BeforeEach} - это аннотация, чтобы пометить метод, который будет выполняться перед каждым тестовым методом.
     * Этот метод выполняется сразу перед запуском каждого отдельного теста, что позволяет настроить начальное
     * состояние для каждого теста или выполнить другие подготовительные действия. @BeforeEach применяется
     * к методу, который вы хотите выполнить перед каждым тестом, и обычно размещается в классе тестов.
     * Например:
     */
    @BeforeEach
    void setUp() {
        getInput = new GetInput();
    }

    @Test
    void inputPoints() {
        // Готовим данные для ввода, заменяя стандартный ввод
        String input = "3\n1 2\n3 4\n5 6\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Вызываем метод, который будет считывать ввод
        getInput.inputPoints();

        // Проверяем, что списки left и right содержат ожидаемые значения
        List<Long> expectedLeft = new ArrayList<>();
        expectedLeft.add(1L);
        expectedLeft.add(3L);
        expectedLeft.add(5L);

        List<Long> expectedRight = new ArrayList<>();
        expectedRight.add(2L);
        expectedRight.add(4L);
        expectedRight.add(6L);

        assertEquals(expectedLeft, getInput.getLeftList());
        assertEquals(expectedRight, getInput.getRightList());
    }

    @Test
    void inputPointsArray() {
        // Готовим данные для ввода, заменяя стандартный ввод
        String input = "3\n1 2\n3 4\n5 6\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Вызываем метод, который будет считывать ввод
        getInput.inputPointsArray();
        System.out.println(Arrays.deepToString(getInput.getPointsArray()));
        // Проверяем, что массив содержит ожидаемые значения
        Long[][] expectedArray = new Long[][]{{1L, 2L}, {3L, 4L}, {5L, 6L}};
        System.out.println(Arrays.deepToString(expectedArray));
        assertArrayEquals(expectedArray, getInput.getPointsArray());
    }
}