package com.example.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.books.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>
{

}