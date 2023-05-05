package com.example.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.books.model.Person;
import com.example.books.service.AddressPersonService;

@RestController
public class AddressPersonController {
	@Autowired
	AddressPersonService apService;
	
	//http://localhost:8080/getAllPersons
	@GetMapping("/getAllPersons")
     public List<Person> fetchAllPersons()
	   {
		  return apService.fetchAllPersons();
	   }
	
	//http://localhost:8080/saveAlldata
	   @PostMapping("/saveAlldata")
	   public Person savePersons(@RequestBody Person p)
	   {
		   return apService.savePersons(p);
	   }
}