package contactsystem;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactList{
    public List<Contact> arrayList = new ArrayList<>();

    public void save(Contact contact){
        this.arrayList.add(contact);
    }
}
