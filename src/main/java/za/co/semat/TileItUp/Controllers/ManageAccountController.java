package za.co.semat.TileItUp.Controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.co.semat.TileItUp.Model.Admin;
import za.co.semat.TileItUp.Model.Customer;
import za.co.semat.TileItUp.Services.AdminService;
import za.co.semat.TileItUp.Services.CustomerService;

import java.util.Optional;

@RestController
@RequestMapping("/Login/login")
public class ManageAccountController {

    @Autowired
    CustomerService customerService;

    @Autowired
    AdminService adminService;

    @PostMapping("/customer")
    public ResponseEntity<Optional<Customer>> customerlogin(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session){
        Optional<Customer> c = customerService.login(email, password);
        if (c.isPresent()){
            session.setAttribute("id", c.get().getId());
        }
        return new ResponseEntity<Optional<Customer>>(c, HttpStatus.OK);
    }

    @PostMapping("/admin")
    public ResponseEntity<Optional<Admin>> adminlogin(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session){
        Optional<Admin> a = adminService.login(email, password);
        if (a.isPresent()){
            session.setAttribute("id", a.get().getId());
        }
        return new ResponseEntity<Optional<Admin>>(a, HttpStatus.OK);
    }

}
