package com.java.functional.programming.generics.zoo;

//public class Cage<T extends Animal & Eats & Runs,U extends Animal & Eats & Runs> {

public class Cage<T extends Animal & Eats & Runs> {

    private T animal1;
    private T animal2;

    public Cage() {
    }

    public Cage(T animal1, T animal2) {
        this.animal1 = animal1;
        this.animal2 = animal2;
    }

    public T getAnimal1() {
        return animal1;
    }

    public void setAnimal1(T animal1) {
        this.animal1 = animal1;
    }

    public T getAnimal2() {
        return animal2;
    }

    public void setAnimal2(T animal2) {
        this.animal2 = animal2;
    }

    public static <T extends Animal> boolean isOkToPutInSame(T animal1, T animal2) {

        return animal1.getType().equals(animal2.getType());
    }

    public void feedAnimal() {
        animal1.eats();
        animal2.eats();
    }

    public void runAnimals() {
        animal1.runs();
        animal2.runs();
    }
}
