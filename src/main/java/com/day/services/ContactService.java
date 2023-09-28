package com.day.services;

import java.util.List;

import com.day.models.Contact;

public interface ContactService {
	
    Contact saveContact(Contact contact);

    List<Contact> getAllContacts();

    Contact getContactById(Long id);

    void deleteContact(Long id);

    Contact updateContact(Long id, Contact updatedContact);

    List<Contact> searchContactsByNameAndAddress(String query);

    List<Contact> searchContactsByAgeRange(int fromAge, int toAge);
}
