package org.example.components;

import org.example.configuration.Bank;
import org.springframework.stereotype.Component;

@Component
public class SBI implements Bank {
    @Override
    public void money() {
        System.out.println("10000000000000000000000000");
    }
}
