package contactsystem;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ContactService {
    List<Contact> getAll();

    void add(Contact contact);
}
