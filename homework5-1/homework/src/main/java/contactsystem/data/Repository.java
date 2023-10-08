package contactsystem.data;

import contactsystem.Contact;
import org.springframework.data.repository.CrudRepository;

public interface Repository
        extends CrudRepository<Contact, Long> {

}
