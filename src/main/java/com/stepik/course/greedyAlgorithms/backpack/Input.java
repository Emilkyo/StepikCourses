package com.stepik.course.greedyAlgorithms.backpack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    private Integer backpack;

    public Integer getBackpack() {
        return backpack;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    private List<Item> itemList;

    public void inputThingsList() {
        try (Scanner scanner = new Scanner(System.in)) {
            int amount = scanner.nextInt();
            backpack = scanner.nextInt();
            itemList = new ArrayList<>();
            for (int i = 0; i < amount; i++)
                itemList.add(new Item(scanner.nextInt(), scanner.nextInt()));
        }
    }
}

