package com.stepik.course.greedyalgo.backpack;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;

public class Backpack {
    private final List<Item> itemList;
    private final int backpackVolume;

    public List<Item> getThingsList() {
        return itemList;
    }

    public Backpack(Input input) {
        itemList = input.getItemList();
        backpackVolume = input.getBackpack();
    }

    public String Calculate() {
        // Сортировка списка thingList по стоимости за единицу веса
        //thingList.sort((thing1, thing2) -> Integer.compare(thing1.getWeight(), thing2.getWeight()));
        itemList.sort(Comparator.comparingDouble(Item::getDensity).reversed());
        double maxValue = 0.0; // Максимальная стоимость вещей в рюкзаке
        int currentWeight = 0; // Текущий вес вещей в рюкзаке

        for (int i = 0; i < itemList.size(); i++) {
            //максимальную стоимость частей предметов
            if (currentWeight + itemList.get(i).getWeight() <= backpackVolume) {
                // Если предмет полностью помещается в рюкзак, добавляем его целиком
                currentWeight += itemList.get(i).getWeight();
                maxValue += itemList.get(i).getCost();
            } else {
                // Если предмет не полностью помещается, берем долю предмета, чтобы заполнить оставшуюся вместимость
                double remainingCapacity = backpackVolume - currentWeight;
                maxValue += (remainingCapacity / itemList.get(i).getWeight()) * itemList.get(i).getCost();
                break; // Вместимость рюкзака исчерпана
            }
        }
        DecimalFormat df = new DecimalFormat("0.000");
        return df.format(maxValue);
    }
}
