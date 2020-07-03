package vn.edu.ntu.quangnghia.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.quangnghia.model.Contact;

public class ContactController extends Application implements IContactController {

    List<Contact> listContacts = new ArrayList<>();

    public ContactController() {
        listContacts.add(new Contact(1,"Lê Thế Dũng","28/06/1998","0369337366","12 Trần Khánh"));
        listContacts.add(new Contact(2,"Lê Thế Dũng","28/06/1998","0369337366","12 Trần Khánh"));
        listContacts.add(new Contact(3,"Lê Thế Dũng","28/06/1998","0369337366","12 Trần Khánh"));
        listContacts.add(new Contact(4,"Lê Thế Dũng","28/06/1998","0369337366","12 Trần Khánh"));
        listContacts.add(new Contact(5,"Lê Thế Dũng","28/06/1998","0369337366","12 Trần Khánh"));
        listContacts.add(new Contact(6,"Lê Thế Dũng","28/06/1998","0369337366","12 Trần Khánh"));
        listContacts.add(new Contact(7,"Lê Thế Dũng","28/06/1998","0369337366","12 Trần Khánh"));
    }

    @Override
    public List<Contact> getAllContact() {
        return listContacts;
    }

    @Override
    public void addContact(Contact contact) {
        listContacts.add(contact);
    }

    @Override
    public void updateContact(Contact contact) {
        for(int i =0; i<listContacts.size(); i++){
            if(listContacts.get(i).getId() == contact.getId()){
                listContacts.get(i).setName(contact.getName());
                listContacts.get(i).setDateOfBirth(contact.getDateOfBirth());
                listContacts.get(i).setPhoneNumber(contact.getPhoneNumber());
                listContacts.get(i).setAddress(contact.getAddress());
            }
        }
    }
}
