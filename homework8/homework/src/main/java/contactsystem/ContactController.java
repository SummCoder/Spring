package contactsystem;

import contactsystem.data.Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
//@SessionAttributes("contactList")
public class ContactController {

    private final Repository orderRepo;

    public ContactController(Repository orderRepo) {
        this.orderRepo = orderRepo;
    }

//    @ModelAttribute(name = "contact")
//    public Contact contact() {
//        return new Contact();
//    }

    // 返回页面
//    @GetMapping
//    public String showContactForm(){
//        return "home";
//    }
    @GetMapping("/contacts")
    public Iterable<Contact> allOrders() {
        return orderRepo.findAll();
    }

//    @GetMapping("/contact/{id}")
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public Optional<Contact> contactById(@PathVariable("id") Long id) {
//        return orderRepo.findById(id);
//    }


    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> tacoById(@PathVariable("id") Long id) {
        Optional<Contact> optContact = orderRepo.findById(id);
        return optContact.map(contact -> new ResponseEntity<>(contact, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping("contact")
    @ResponseStatus(HttpStatus.CREATED)
    public Contact postContact(@RequestBody Contact contact) {
        return orderRepo.save(contact);
    }

    @PutMapping(path="/contact/{orderId}", consumes="application/json")
    public Contact putOrder(
            @PathVariable("orderId") Long orderId,
            @RequestBody Contact contact) {
        contact.setId(orderId);
        return orderRepo.save(contact);
    }

    @DeleteMapping("/contact/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId) {
        try {
            orderRepo.deleteById(orderId);
        } catch (EmptyResultDataAccessException e) {}
    }

//    @ModelAttribute(name = "contactList")
//    public ContactList contacts() {
//        return new ContactList();
//    }

//    @PostMapping
//    public String processContact(
//            @Valid Contact contact, Errors errors,
//            @ModelAttribute ContactList contacts) {
//
//        if (errors.hasErrors()) {
//            return "home";
//        }
//
//        contacts.save(contact);
//        orderRepo.save(contact);
//
//        return "redirect:/api/contacts";
//    }


}