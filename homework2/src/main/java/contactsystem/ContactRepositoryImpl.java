package contactsystem;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactRepositoryImpl implements ContactRepository{
    @Override
    public List<Contact> findAll() {
        return arrayList;
    }

    @Override
    public void save(Contact contact) {
        arrayList.add(contact);
    }

    @Override
    public void clear() {
        arrayList.clear();
    }
}
