package com.stepik.course.greedyalgo.Heap;

import org.junit.jupiter.api.Test;

class HeapTest {
    @Test
    void inputTest() {
        String input =
                "Insert 200\n" +
                        "Insert 10\n" +
                        "Insert 5\n" +
                        "Insert 500\n" +
                        "ExtractMax\n" +
                        "ExtractMax\n" +
                        "ExtractMax\n" +
                        "ExtractMax";
        Heap heap = new Heap();
        heap.input();
    }
}