package contactsystem;

import contactsystem.data.Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/")
@SessionAttributes("contacts")

public class ContactController {

    private Repository orderRepo;

    public ContactController(Repository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @ModelAttribute(name = "contact")
    public Contact contact() {
        return new Contact();
    }

    // 返回页面
    @GetMapping
    public String showContactForm(){
        return "home";
    }

    @ModelAttribute(name = "contacts")
    public ContactRepository contacts() {
        return new ContactRepositoryImpl();
    }

    @PostMapping
    public String processContact(
            @Valid Contact contact, Errors errors,
            @ModelAttribute ContactRepositoryImpl contacts) {

        if (errors.hasErrors()) {
            return "home";
        }

        contacts.save(contact);
        orderRepo.save(contact);

        return "redirect:/";
    }


}