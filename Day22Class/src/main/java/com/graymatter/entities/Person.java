package com.graymatter.entities;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.domain.Persistable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="project22Person")
public class Person implements Persistable<Long>{
	
@Id
private long adhaarNumber;
@Column(name="personName")
@Size(min=3,message="person name must be min 3 chars length")
private String name;
@NotBlank
@Pattern(regexp = "[6789][0-9]{9}",message="mobile num must be 10 length starting with either 6,7,8,9")
private String mobileNum;
@Range(min=18,message="Age must be more than 18 to cast vote")
private int age;
@Email
private String email;
@Pattern(regexp = "(A|B|AB|O)[+-]")
private String blood;
@Transient
@Builder.Default
private boolean isNewId=true;

@Override
public Long getId() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean isNew() {
	// TODO Auto-generated method stub
	return isNewId;
}
}
