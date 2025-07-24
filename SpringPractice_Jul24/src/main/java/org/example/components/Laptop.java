package org.example.components;

import org.example.repo.Devices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop {

    @Autowired
    private Devices d;

    public void screenType(){
        d.deviceType();
    }
}
