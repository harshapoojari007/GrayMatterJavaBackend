package com.graymatter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.graymatter.entities.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Service
public class CriteriaService {
	
	@PersistenceContext
    private EntityManager em;

    public List<Person> getAllPersonByCriteria() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person> root = cq.from(Person.class);
        List<Person> pList = em.createQuery(cq.select(root)).getResultList();
        return pList;
    }
	
}

