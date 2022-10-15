package com.contact.service;

import com.contact.dao.ContactDao;
import com.contact.domain.Contact;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrador
 */
@Service
public class ContactService implements IContactService {

    @Autowired
    private ContactDao contactDao;

    @Override
    @Transactional(readOnly = true)
    public List<Contact> list() {
        List<Contact> contacts = null;
        try {
            contacts = (List<Contact>) contactDao.findAll();
        } catch (Exception exc) {
            throw exc;
        }
        return contacts;
    }

    @Override
    @Transactional
    public Contact save(Contact contact) {
        return contactDao.save(contact);
    }

    @Override
    @Transactional
    public Contact update(Long id, Contact contact) {
        contact.setId(id);
        return contactDao.save(contact);
    }

    @Transactional
    public void updateDocument(Long id, Contact contact) {
        contactDao.updateDocument(id, contact.getDocument());
    }

    @Transactional
    public void updateName(Long id, Contact contact) {
        contactDao.updateName(id, contact.getName());
    }

    @Transactional
    public void updatePosition(Long id, Contact contact) {
        contactDao.updatePosition(id, contact.getPosition());
    }

    @Override
    @Transactional
    public void delete(Contact contact) {
        contactDao.delete(contact);
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findUser(Contact contact) {
        Optional<Contact> user = contactDao.findById(contact.getId());
        return contact;
    }

}
