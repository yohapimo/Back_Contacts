package com.contact.service;

import com.contact.domain.Contact;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface IContactService {

    public List<Contact> list();

    public Contact save(Contact contact);

    public Contact update(Long id, Contact contact);

    public void delete(Contact contact);

    public Contact findUser(Contact contact);

}
