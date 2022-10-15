package com.contact.controller;

import com.contact.domain.Contact;
import com.contact.service.ContactService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrador
 */
@Slf4j
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping(path = "/contacts")
    public List<Contact> list() {
        return contactService.list();
    }

    @PostMapping(path = "/contact")
    public ResponseEntity<Contact> create(Contact contact) {

        log.info("Contacto a crear: {}", contact);
        contactService.save(contact);
        return new ResponseEntity<Contact>(contact, HttpStatus.CREATED);

    }

    @DeleteMapping(path = "/contact/{id}")
    public ResponseEntity<Contact> delete(Contact contact) {
        log.info("Contacto a borrar: {}", contact);
        contactService.delete(contact);
        return new ResponseEntity<Contact>(contact, HttpStatus.OK);
    }

    @PutMapping(path = "/contact/{id}")
    public ResponseEntity<Contact> update(Contact contact, @PathVariable("id") Long id) {
        log.info("Contacto a modificar: {}", contact);
        contactService.update(id, contact);
        return new ResponseEntity<Contact>(contact, HttpStatus.OK);
    }

    @PatchMapping(path = "/contact/document/{id}")
    public ResponseEntity<Contact> updateDocument(Contact contact, @PathVariable("id") Long id) {
        log.info("Contacto a modificar: {}", contact);
        contactService.updateDocument(id, contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PatchMapping(path = "/contact/name/{id}")
    public ResponseEntity<Contact> updateName(Contact contact, @PathVariable("id") Long id) {
        log.info("Contacto a modificar: {}", contact);
        contactService.updateName(id, contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PatchMapping(path = "/contact/position/{id}")
    public ResponseEntity<Contact> updatePosition(Contact contact, @PathVariable("id") Long id) {
        log.info("Contacto a modificar: {}", contact);
        contactService.updatePosition(id, contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }
}
