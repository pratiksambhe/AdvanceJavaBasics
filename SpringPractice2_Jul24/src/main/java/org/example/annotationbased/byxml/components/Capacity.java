package org.example.annotationbased.byxml.components;

import org.example.annotationbased.byclassconfig.repo.Vehical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Capacity {
@Autowired
    private  Vehical v;

public void personCarry(){
    v.info();
}
}
