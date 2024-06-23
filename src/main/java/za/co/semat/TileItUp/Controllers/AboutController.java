package za.co.semat.TileItUp.Controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import za.co.semat.TileItUp.Services.CustomerService;

@Controller
public class AboutController {


    @Autowired
    private CustomerService customerService;

    ManageAccountController manageAccountController;

    @GetMapping({"/about"})
    public String getAbout(HttpSession session){

        if (true){

        }

        return "AboutUs.jsp";
    }

}
