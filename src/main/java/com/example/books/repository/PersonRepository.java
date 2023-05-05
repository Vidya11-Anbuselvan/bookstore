package com.example.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.books.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long>
{

}