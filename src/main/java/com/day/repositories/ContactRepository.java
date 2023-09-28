package com.day.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.day.models.Contact;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    

    @Query("SELECT c FROM Contact c WHERE c.firstName LIKE %:query% OR c.secondName LIKE %:query% OR c.addresses LIKE %:query%")
    List<Contact> searchContactsByNameAndAddress(String query);
    
    @Query("SELECT c FROM Contact c WHERE c.dateOfBirth BETWEEN :fromDate AND :toDate")
    List<Contact> searchContactsByAgeRange(@Param("fromDate") int fromAge, @Param("toDate") int toAge);
}

