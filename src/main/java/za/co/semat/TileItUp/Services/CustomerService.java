package za.co.semat.TileItUp.Services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.session.web.http.HttpSessionIdResolver;
import org.springframework.stereotype.Service;
import za.co.semat.TileItUp.Model.Customer;
import za.co.semat.TileItUp.Model.ServiceClass;
import za.co.semat.TileItUp.Repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> allCustomers(){
        return customerRepository.findAll();
    }

    public Customer addCustomer(String name, String email, String password, String gender, String surname, List<String> address){

        Customer c = new Customer(name, email, password, surname, gender, address);

        return customerRepository.save(c);
    }

    public Customer update(ObjectId id, String name, String surname){

        Customer existingCustomer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
        name = name.trim();
        surname = surname.trim();
        if (!name.isEmpty()){existingCustomer.setName(name);}
        if (!surname.isEmpty()){existingCustomer.setSurname(surname);}
        return customerRepository.save(existingCustomer);
    }

    public Customer updatepassword(ObjectId id, String password){

        Customer existingCustomer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
        password = password.trim();
        if (!password.isEmpty()){existingCustomer.setPassword(password);}
        return customerRepository.save(existingCustomer);
    }

    public Customer delete(ObjectId id, HttpServletRequest request){

        HttpSession session = request.getSession(true);

        Optional<Customer> customer = customerRepository.findById(id);

        Customer c = customer.orElseThrow(() -> new RuntimeException("Service not found is not present"));

        session.setAttribute("id", c.getId());

        customerRepository.delete(c);

        return c;
    }

    public Optional<Customer> login(String email, String password) {

        Optional<Customer> c = customerRepository.findByEmail(email);

        if (c.isPresent()) {
            Customer customer = c.get();
            if (customer.getPassword().equals(password)) { // Check if the password matches



                return Optional.of(customer); // Return Optional containing the customer
            } else {
                // Incorrect password
                return Optional.empty();
            }
        } else {
            return Optional.empty();
        }
    }



}
