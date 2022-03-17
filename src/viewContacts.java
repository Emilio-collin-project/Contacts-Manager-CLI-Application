import java.util.ArrayList;

public class viewContacts {
    public viewContacts(String contact, String number) {
        this.contact = contact;
        this.number = number;
    }

    public String contact;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String number;

    public static void printContacts(ArrayList<contact>) {

        System.out.println("Here are the contacts. ");

    }
}

