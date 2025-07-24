package org.example.components;

import org.example.repo.Devices;

//@Component
public class Screen implements Devices {

    @Override
    public void deviceType(){
        System.out.println("Amoled Display");
    }
}
