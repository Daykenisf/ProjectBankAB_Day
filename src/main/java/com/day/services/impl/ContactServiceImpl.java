package com.day.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day.models.Contact;
import com.day.repositories.ContactRepository;
import com.day.services.ContactService;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public Contact updateContact(Long id, Contact updatedContact) {
        Contact existingContact = contactRepository.findById(id).orElse(null);
        if (existingContact != null) {
            existingContact.setFirstName(updatedContact.getFirstName());
            existingContact.setSecondName(updatedContact.getSecondName());
            existingContact.setAddresses(updatedContact.getAddresses());
            existingContact.setDateOfBirth(updatedContact.getDateOfBirth());
            existingContact.setPhoneNumbers(updatedContact.getPhoneNumbers());
            existingContact.setPersonalPhoto(updatedContact.getPersonalPhoto());
            return contactRepository.save(existingContact);
        }
        return null;
    }

    @Override
    public List<Contact> searchContactsByNameAndAddress(String query) {
        return contactRepository.searchContactsByNameAndAddress(query);
    }

    @Override
    public List<Contact> searchContactsByAgeRange(int fromAge, int toAge) {
        return contactRepository.searchContactsByAgeRange(fromAge, toAge);
    }
}