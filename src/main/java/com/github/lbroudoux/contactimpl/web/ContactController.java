package com.github.lbroudoux.contactimpl.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;
/**
 * @author laurent
 */
@RestController
@RequestMapping("/api/v1")
public class ContactController {

    private static List<Contact> contacts = new ArrayList<>();

    static {
      contacts.add(new Contact("Laurent", "Broudoux", "laurent@example.com", "123456789"));
      contacts.add(new Contact("Yacine", "Kheddache", "yacine@example.com", "987654321"));
      contacts.add(new Contact("Patrice", "Lachance", "patrice@example.com", "azertyuiop"));
      contacts.add(new Contact("Jaafar", "Chraibi", "jaafar@example.com", "qsdfghjklm"));
    }    

    @RequestMapping(value = "/{userId}/contacts", method = RequestMethod.GET, produces = "application/json")
    public List<Contact> getContacts(@PathVariable("userId") String userId) {
        return contacts;
    }

    @RequestMapping(value = "/{userId}/contacts", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact, @PathVariable("userId") String userId) {
        if (contact != null) {
            return new ResponseEntity<>(contact, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}