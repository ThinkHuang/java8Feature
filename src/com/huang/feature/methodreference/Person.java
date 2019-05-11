package com.huang.feature.methodreference;

public class Person
{
private String name;
    
    private String birthday;
 
    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }
 
    public String getBirthday() {
        return birthday;
    }
 
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
 
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
