package vn.edu.ntu.quangnghia.model;

public class Contact {
    int id;
    String Name;
    String DateOfBirth;
    String PhoneNumber;
    String Address;

    public Contact() {
    }

    public Contact(int id, String name, String dateOfBirth, String phoneNumber, String address) {
        this.id = id;
        Name = name;
        DateOfBirth = dateOfBirth;
        PhoneNumber = phoneNumber;
        Address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
