package com.github.lbroudoux.contactimpl.web;

import org.springframework.http.HttpStatus;
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
      contacts.add(new Contact("Laurent", "Broudoux", "lbroudou@redhat.com", "123456789"));
      contacts.add(new Contact("Yacine", "Kheddache", "yacine@redhat.com", "987654321"));
      contacts.add(new Contact("Patrice", "Lachance", "patrice.lachance@socgen.com", "azertyuiop"));
      contacts.add(new Contact("Jaafar", "Chraibi", "jchraibi@redhat.com", "qsdfghjklm"));
    }    

    @RequestMapping(value = "/{userId}/contacts", method = RequestMethod.GET)
    public List<Contact> getContacts(@PathVariable("userId") String userId) {
        return contacts;
    }

    @RequestMapping(value = "/{userId}/contacts", method = RequestMethod.POST)
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact, @PathVariable("userId") String userId) {
        if (contact != null) {
            return new ResponseEntity<>(contact, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}