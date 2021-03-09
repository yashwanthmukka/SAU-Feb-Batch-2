package com.assignment.Hibernate2.task3;

import javax.persistence.*;

@Entity
public class Audience {
	
	@Id
    private int age;
    private String name;
    
    @ManyToOne
    private Screen screen1;


    public Screen getScreen1()
    {
       return screen1;
    }
    public void setScreen1(Screen screen1)
    {
         this.screen1=screen1;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
