package za.co.semat.TileItUp.Controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.semat.TileItUp.Model.Customer;
import za.co.semat.TileItUp.Model.Facination;
import za.co.semat.TileItUp.Services.FacinationService;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/facinations")
public class FacinationController {

    @Autowired
    private FacinationService facinationService;

    @GetMapping()
    public ResponseEntity<List<Facination>> getAllFacination(){

        return new ResponseEntity<List<Facination>>(facinationService.allFacination(), HttpStatus.OK);

    }

    @PostMapping("addfacination")
    public void addNewFacination(@RequestParam("serviceId") ObjectId serviceId, @RequestParam("customerId") ObjectId customerId){

        facinationService.addFacination(serviceId, customerId, Instant.now());

    }

    @PostMapping("/addremovefacination")
    public boolean facinationcreated(@RequestParam("customerId") ObjectId customerId,@RequestParam("serviceId") ObjectId serviceId){

        return facinationService.isFacinationCreated(customerId, serviceId, Instant.now());
    }

    @DeleteMapping("/deletefacination")
    public void deleteTheFacination(@RequestParam("facinationId") ObjectId id){

        facinationService.removeFacinaion(id);
    }
}
