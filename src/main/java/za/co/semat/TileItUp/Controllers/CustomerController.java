package za.co.semat.TileItUp.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.semat.TileItUp.Model.Customer;
import za.co.semat.TileItUp.Services.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers(){

        List<Customer> list = customerService.allCustomers();

        return list;

    }

    @PostMapping("/addcustomer")
    public ResponseEntity<Customer> addTheCustomer(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("password") String password,@RequestParam("surname") String surname,@RequestParam("gender") String gender,@RequestParam("province") String province,@RequestParam("town") String town){

        List<String> address = new ArrayList<>();
        address.add(province);
        address.add(town);

        return new ResponseEntity<Customer>(customerService.addCustomer(name, email, password,gender,surname,address), HttpStatus.CREATED);
    }

    @PostMapping("/delete")
    public Customer detetecustomer(@RequestParam("id")ObjectId id, HttpServletRequest request){

        return customerService.delete(id, request);

    }

    @PostMapping("/updatedetails")
    public ResponseEntity<Customer> updatecustomer(@RequestParam("id") ObjectId id,@RequestParam("name") String name,@RequestParam("surname") String surname){

        return new ResponseEntity<Customer>(customerService.update(id, name, surname), HttpStatus.OK);
    }

    @PostMapping("/updatepassword")
    public ResponseEntity<Customer> updatepassword(@RequestParam("id") ObjectId id, @RequestParam("password") String password){

        return new ResponseEntity<Customer>(customerService.updatepassword(id,password), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Optional<Customer>> customerlogin(@RequestParam("email") String email, @RequestParam("password") String password){

        Optional<Customer> c = customerService.login(email, password);



        return new ResponseEntity<Optional<Customer>>(c, HttpStatus.OK);
    }

}
