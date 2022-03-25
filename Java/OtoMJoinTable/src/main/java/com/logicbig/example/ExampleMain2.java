package com.logicbig.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

public class ExampleMain2 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test1");
        try {
            persistEntity(emf);
            nativeQueries(emf);
            loadEntityA(emf);
            loadEntityB(emf);
        } finally {
            emf.close();
        }
    }

    private static void nativeQueries(EntityManagerFactory emf) {
        System.out.println("-- native queries --");
        EntityManager em = emf.createEntityManager();
        ExampleMain.nativeQuery(em, "Select * from EntityA");
        ExampleMain.nativeQuery(em, "Select * from EntityB");
        ExampleMain.nativeQuery(em, "Select * from MY_JOIN_TABLE");
    }

    private static void persistEntity(EntityManagerFactory emf) {
        System.out.println("-- Persisting entities --");
        EntityManager em = emf.createEntityManager();

        EntityB entityB = new EntityB();
        entityB.setStr("testStringB");

        EntityB entityB2 = new EntityB();
        entityB2.setStr("testStringB 2");

        EntityA entityA = new EntityA();
        entityA.setEntityBList(Arrays.asList(entityB, entityB2));

        em.getTransaction().begin();
        em.persist(entityA);
        em.persist(entityB);
        em.persist(entityB2);
        em.getTransaction().commit();

        em.close();
    }

    private static void loadEntityA(EntityManagerFactory emf) {
        System.out.println("-- Loading EntityA --");
        EntityManager em = emf.createEntityManager();
        List<EntityA> entityAList = em.createQuery("Select t from EntityA t").getResultList();
        for (EntityA entityA : entityAList) {
            System.out.println(entityA);
        }
        em.close();
    }

    private static void loadEntityB(EntityManagerFactory emf) {
        System.out.println("-- Loading EntityB --");
        EntityManager em = emf.createEntityManager();
        List<EntityB> entityBList = em.createQuery("Select t from EntityB t").getResultList();
        entityBList.forEach(System.out::println);
        em.close();
    }
}
