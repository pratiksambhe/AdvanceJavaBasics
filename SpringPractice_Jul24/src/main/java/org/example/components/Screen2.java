package org.example.components;

import org.example.repo.Devices;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
public class Screen2 implements Devices {
public void deviceType(){
    System.out.println("Normal Display");
}
}
