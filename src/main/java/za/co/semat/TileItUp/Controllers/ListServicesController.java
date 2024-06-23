package za.co.semat.TileItUp.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import za.co.semat.TileItUp.Services.CustomerService;
import za.co.semat.TileItUp.Services.ServiceSevice;

import java.net.http.HttpRequest;
import java.util.List;

@Controller
public class ListServicesController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ServiceSevice serviceSevice;

    ManageAccountController manageAccountController;

    @GetMapping({"/services"})
    public String getServices(HttpServletRequest request){

        List list = serviceSevice.allServices();

        request.setAttribute("list",list);


        return "Services.jsp";
    }

}
