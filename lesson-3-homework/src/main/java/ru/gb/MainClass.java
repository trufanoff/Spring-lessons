package ru.gb;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.math.BigDecimal;

public class MainClass {
    public static void main(String[] args) {
        EntityManagerFactory emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = null;
        // === INSERT ===
        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Customer customer1 = new Customer(null, "Alex");
        Customer customer2 = new Customer(null, "Peter");
        em.persist(customer1);
        em.persist(customer2);

        Product product1 = new Product(null, "rice", new BigDecimal(40));
        Product product2 = new Product(null, "milk", new BigDecimal(20));
        em.persist(product1);
        em.persist(product2);

        em.getTransaction().commit();
        em.close();

        // === посмотреть, какие товары покупал клиент ===
        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Customer customerFromDB = em.find(Customer.class, 1L);
        System.out.println(customerFromDB);
        System.out.println(customerFromDB.getProducts());
        em.getTransaction().commit();
        em.close();

        // === клиенты купили определенный товар ===
        em = emFactory.createEntityManager();
        em.getTransaction().begin();
        Product productFromDB = em.find(Product.class, 2L);
        System.out.println(productFromDB);
        System.out.println(productFromDB.getCustomers());
        em.getTransaction().commit();
        em.close();

        // === возможность удалять из базы товары/покупателей ===
        Product product = em.find(Product.class, 1L);
        em.remove(product);
        em.getTransaction().commit();
        em.close();
    }
}
