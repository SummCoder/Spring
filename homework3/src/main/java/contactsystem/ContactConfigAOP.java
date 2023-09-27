package contactsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
//@ComponentScan
public class ContactConfigAOP {
    @Bean
    public ContactAOP contactAOP(){
        return new ContactAOP();
    }
    @Bean
    public ContactRepository contactRepository(){
        return new ContactRepositoryImpl();
    }
    @Bean
    public ContactService contactService(){
        return new ContactServiceImpl(contactRepository());
    }
}
