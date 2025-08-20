package com.harini;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Practice a1=new Practice();
        a1.setAid(103);
        a1.setName("Suseela");
        a1.setTech("Java");


        SessionFactory factory = new Configuration()
                .addAnnotatedClass(com.harini.Practice.class)
                .configure()
                .buildSessionFactory();

        Session session = factory.openSession();

        Transaction transaction=session.beginTransaction();

        session.merge(a1);
        //session.persist(a1);
        transaction.commit();

        session.close();
        factory.close();
    }
}