package com.java.functional.programming.generics.zoo;

public class Zoo {

    static public void main(String[] args) {
        // Cage<Lion, Tiger> cage = new Cage<>(new Lion(), new Tiger());
//        cage.setAnimal1(new Tiger());

        Lion lion1 = new Lion();
        Lion lion2 = new Lion();
        Tiger tiger = new Tiger();
        Cage<Lion> cage1 = new Cage<>(lion1, lion2);


        System.out.println(Cage.isOkToPutInSame(lion1, tiger));

//        Cage<String> cage1 = new Cage<String>();

//        System.out.println(cage.getAnimal1());
//        System.out.println(cage.getAnimal2());

        




    }
}
