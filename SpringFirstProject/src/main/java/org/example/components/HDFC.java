package org.example.components;

import org.example.configuration.Bank;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class HDFC implements Bank {

    @Override
    public void money() {
        System.out.println("9000000000");
    }
}
