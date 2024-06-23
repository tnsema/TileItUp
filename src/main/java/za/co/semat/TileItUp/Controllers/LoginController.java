package za.co.semat.TileItUp.Controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.semat.TileItUp.Model.Admin;
import za.co.semat.TileItUp.Model.Customer;
import za.co.semat.TileItUp.Services.AdminService;
import za.co.semat.TileItUp.Services.CustomerService;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AdminService adminService;

    ManageAccountController manageAccountController;

    @PostMapping({"/login"})
    public String getCustomer(@RequestParam("email") String email, @RequestParam("password") String password,HttpSession session){

        String page = "";

        Optional<Admin> admin = adminService.login(email, password);

        if (admin.isPresent()){
            session.setAttribute("obj", admin.get());
            page = "AdminHome.jsp";
        }
        else {
            Optional<Customer> cust = customerService.login(email, password);

            if (cust.isPresent()){
                session.setAttribute("obj", cust.get());
                page = "ClientHome.jsp";
            }else{
                page = "Welcome.jsp";
            }
        }

        return page;
    }

}
