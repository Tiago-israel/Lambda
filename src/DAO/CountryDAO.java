/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Country;

/**
 *
 * @author tiago
 */
public class CountryDAO {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    private void open(){
        emf = Persistence.createEntityManagerFactory("LambdaPU");
        em = emf.createEntityManager();
    }
    
    private void close(){
        em.close();
        emf.close();
    }
    
    public List<Country>finAll(){
        try{
            this.open();
            Query query = em.createNamedQuery("Country.findAll");
            return query.getResultList();
        }finally{
            this.close();
        }
    }
    
}
