package com.logicbig.example;

import javax.persistence.*;
import java.util.List;

@Entity
public class EntityA {
    @Id
    @GeneratedValue
    private int myIdA;
    @OneToMany
    @JoinTable(name = "MY_JOIN_TABLE",
            joinColumns = {@JoinColumn(name = "MY_ENTITY_A_FK")},
            inverseJoinColumns = {@JoinColumn(name = "MY_ENTITY_B_FK")}
    )
    private List<EntityB> entityBList;

    public List<EntityB> getEntityBList() {
        return entityBList;
    }

    public void setEntityBList(List<EntityB> entityBList) {
        this.entityBList = entityBList;
    }

    @Override
    public String toString() {
        return "EntityA{" +
                "myIdA=" + myIdA +
                ", entityBList=" + entityBList +
                '}';
    }
}