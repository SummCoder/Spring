package contactsystem;

import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
public class ContactList{
    public ArrayList<Contact> arrayList = new ArrayList<>();

    public void save(Contact contact){
        this.arrayList.add(contact);
    }
}
