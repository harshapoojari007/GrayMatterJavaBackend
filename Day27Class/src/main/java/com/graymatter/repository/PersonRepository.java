package com.graymatter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.graymatter.entities.Person;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
	
	    @Query(name="getByName")
         List<Person> getByName(@Param("name") String name);
	    
	   @Query(name="getByNameAndAge")
	   List<Person> getByNameAndAge(@Param("name") String name,@Param("age") int age);
	   
	   @Query(name="getByNameLAndAge25")
	   List<Person> getByNameLAndAge25();
}
