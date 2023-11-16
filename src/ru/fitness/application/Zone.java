package ru.fitness.application;

public enum Zone {
    GYM ("Тренажёрный зал", (byte) 20),
    POOL ("Бассейн", (byte) 20),
    GROUP ("Групповые занятия", (byte) 20);

    private final String name;
    private final byte maxCapacity;

    Zone(String name, byte maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
    }

    public String getName() {
        return name;
    }

    public byte getMaxCapacity() {
        return maxCapacity;
    }




}
