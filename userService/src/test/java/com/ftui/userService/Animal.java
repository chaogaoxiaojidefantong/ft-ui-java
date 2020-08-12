package com.ftui.userService;

public class Animal {
    public String name;
    private int id;
    public Animal(String myName, int myid) {
        name = myName;
        id = myid;
    }
    public Animal(String name){

    }
    public Animal(){
        this.name="33";
    }
    public void eat(){
        System.out.println(name+"正在吃");
    }
    public void sleep(){
        System.out.println(name+"正在睡");
    }
    public void introduction() {
        System.out.println("大家好！我是"         + id + "号" + name + ".");
    }
}
