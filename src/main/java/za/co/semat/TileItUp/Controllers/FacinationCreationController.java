package za.co.semat.TileItUp.Controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.semat.TileItUp.Services.FacinationService;

import java.time.Instant;

@Controller
public class FacinationCreationController {

    @Autowired
    FacinationService facinationService;

    @PostMapping("/interested")
    public String createfacination(@RequestParam("serviceId") ObjectId serviceId, @RequestParam("customerId") ObjectId customerId){

        facinationService.addFacination(serviceId, customerId, Instant.now());

        return "Welcome.jsp";
    }

}
