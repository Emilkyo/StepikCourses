package com.stepik.course.divideandconquer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeSortTest {
    Long startTime;

    @BeforeEach
    void startTime() {
        startTime = System.currentTimeMillis();
    }

    @AfterEach
    void finishTime() {
        Long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }

    @Test
    void inputTest() {
        String input = "5 1 5 8 12 13\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        long expected = 0;
        MergeSort ms = new MergeSort();
        System.out.println(Arrays.toString(ms.getArray()));
        assertEquals(expected, ms.getCountInversions());
        System.out.println(ms.getCountInversions());
    }

    @Test
    void inputTest2() {
        String input = """
                7
                7 6 5 4 3 2 1
                """;
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        long expected = 21;
        MergeSort ms = new MergeSort();
        System.out.println(Arrays.toString(ms.getArray()));
        assertEquals(expected, ms.getCountInversions());
        System.out.println(ms.getCountInversions());
    }
}