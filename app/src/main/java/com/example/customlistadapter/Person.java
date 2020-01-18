package com.example.customlistadapter;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private int picNum;

    public Person(String name, int age, int picNum) {
        this.name = name;
        this.age = age;
        this.picNum = picNum;
    }

    //compareTo for sorting
    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPicNum() {
        return picNum;
    }

    public void setPicNum(int picNum) {
        this.picNum = picNum;
    }

}
