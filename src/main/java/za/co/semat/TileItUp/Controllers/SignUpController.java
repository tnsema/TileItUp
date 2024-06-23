package za.co.semat.TileItUp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.semat.TileItUp.Model.Customer;
import za.co.semat.TileItUp.Services.CustomerService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SignUpController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/signup")
    public String signUp(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("confirmpassword") String confirmpassword, @RequestParam("surname") String surname, @RequestParam("gender") String gender, @RequestParam("province") String province, @RequestParam("town") String town){

        String page = "";

        if (password.equals(confirmpassword)){
            List<String> address = new ArrayList<>();
            address.add(province);
            address.add(town);

            Customer c = customerService.addCustomer(name, email, password,gender,surname,address);
            if (c == null){
                page="Welcome.jsp";
            }else {
                page="success_create.jsp";
            }
        }else{
            page="Welcome.jsp";
        }





        return page;
    }

}
