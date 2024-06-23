package za.co.semat.TileItUp.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import za.co.semat.TileItUp.Services.CustomerService;
import za.co.semat.TileItUp.Services.FacinationService;
import za.co.semat.TileItUp.Services.ServiceSevice;

import java.util.List;

@Controller
public class ListFacinationsController {


    @Autowired
    private CustomerService customerService;

    @Autowired
    private ServiceSevice serviceSevice;

    @Autowired
    private FacinationService facinationService;

    ManageAccountController manageAccountController;

    @GetMapping("/listfacination")
    public String getServices(HttpServletRequest request){

        List list = facinationService.allFacination();

        request.setAttribute("list",list);


        return "list_facinations.jsp";
    }
}
