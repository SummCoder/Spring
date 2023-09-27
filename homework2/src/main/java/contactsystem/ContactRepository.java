package contactsystem;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public interface ContactRepository {
    ArrayList<Contact> arrayList = new ArrayList<>();
    List<Contact> findAll();

    void save(Contact contact);

    void clear();
}
