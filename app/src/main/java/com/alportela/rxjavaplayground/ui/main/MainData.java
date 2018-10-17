/*
 * Created by Alberto on 17/10/2018
 */

package com.alportela.rxjavaplayground.ui.main;

public class MainData {

    private String name;
    private int age;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return name + ", " + age + " years old with email: " + email;
    }
}
