package org.example.BeanlifeCycle.component;

import org.example.BeanlifeCycle.repo.Animals;

import java.security.acl.AclNotFoundException;

public class Dog implements Animals {
    @Override
    public void info() {
        System.out.println("This is Dog");
    }
}
