package com.stepik.course.greedyalgo.backpack;

public class Item {
    private final int cost;
    private final int weight;

    public Item(int cost, int weight) {
        this.cost = cost;
        this.weight = weight;
    }

    public int getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

    public double getDensity() {
        return (double) cost / weight;
    }

    @Override
    public String toString() {
        return "Item(cost=" + cost + ", weight=" + weight + ")";
    }
}
