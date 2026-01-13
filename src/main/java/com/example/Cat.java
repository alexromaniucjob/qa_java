package com.example;

import java.util.List;

public class Cat {
    //1. Создать интерфейс для класса-зависимости. - Predator
    //2. Создать в зависимом классе поле того же типа, что и интерфейс.
    private final Predator predator;

    //3. Создать конструктор с параметром того же типа, что и интерфейс
    public Cat(Predator predator) {
        this.predator = predator;
    }

    public String getSound() {

        return "Мяу";
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }

}
