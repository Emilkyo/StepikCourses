package com.stepik.course.greedyAlgorithms;

import com.stepik.course.fibonacci.GetInput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SegmentsTest {
    private Segments points;
    private GetInput testInput;

    @BeforeEach
    void setUp() {
        testInput = new GetInput();
    }

    @AfterEach
    void tearDown() {
        // Освобождаем ресурсы после каждого тестового метода
        testInput = null;
        points = null;
    }

    @Test
    void testSortLinesWithTestData() {
        // Здесь вы вызываете SortLines и проверяете, что она сортирует массив правильно
        // Используйте testData или создайте другие фиктивные данные для этого теста
        Long[][] testData = new Long[][]{{1L, 2L}, {3L, 4L}, {5L, 6L}};
        testInput.setPointsArray(testData);
        points = new Segments(testInput);

        Long[][] expectedSorted = new Long[][]{{1L, 2L}, {3L, 4L}, {5L, 6L}};
        assertArrayEquals(expectedSorted, points.getSegments());
    }

    @Test
    void testSortLinesWithTestData2() {
        // Здесь вы можете вызвать SortLines и проверить, что она сортирует массив правильно
        // Используйте другие фиктивные данные для этого теста
        Long[][] anotherFakeData = new Long[][]{{9L, 10L}, {7L, 8L}, {11L, 12L}};
        testInput.setPointsArray(anotherFakeData);
        points = new Segments(testInput);

        Long[][] expectedSorted = new Long[][]{{7L, 8L}, {9L, 10L}, {11L, 12L}};
        assertArrayEquals(expectedSorted, points.getSegments());
    }
}
