package za.co.semat.TileItUp.Controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import za.co.semat.TileItUp.Model.Customer;
import za.co.semat.TileItUp.Services.CustomerService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CustomerService customerService;

    @GetMapping({"/","/home"})
    public String getHome(HttpSession session){

     List<Customer> list = customerService.allCustomers();

     session.setAttribute("list", list);

        return "Welcome.jsp";
    }
}
