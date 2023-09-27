package contactsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan
public class ContactConfig {
    @Bean
    public ContactRepository contactRepository(){
        return new ContactRepositoryImpl();
    }
    @Bean
    public ContactService contactService(){
        return new ContactServiceImpl(contactRepository());
    }
}
