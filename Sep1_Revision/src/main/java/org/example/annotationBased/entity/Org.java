package org.example.annotationBased.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Org {

    private Organism organism;

    @Autowired
    public void setOrganism(Organism organism){
        this.organism=organism;
    }

    public void info(){
        organism.infoOrganism();
    }
}
