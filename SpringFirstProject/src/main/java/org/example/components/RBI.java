package org.example.components;

import org.example.configuration.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RBI {
    @Autowired
    private Bank b;
    public void BankAukad(){
        b.money();
    }
}
