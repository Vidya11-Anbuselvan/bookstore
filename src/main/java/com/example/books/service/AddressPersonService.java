package com.example.books.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.books.model.Person;
import com.example.books.repository.PersonRepository;

@Service
public class AddressPersonService {
	@Autowired
	PersonRepository perRepository;
	public List<Person>fetchAllPersons()
	   {
		   return perRepository.findAll();
	   }
    public Person savePersons(Person p)
	   {
		   return perRepository.save(p);
	   }
}

