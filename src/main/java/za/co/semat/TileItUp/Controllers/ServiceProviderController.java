package za.co.semat.TileItUp.Controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.semat.TileItUp.Model.ServiceProvider;
import za.co.semat.TileItUp.Services.ServiceProviderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/serviceproviders")
public class ServiceProviderController {

    @Autowired
    private ServiceProviderService serviceProviderService;

    @GetMapping
    public ResponseEntity<List<ServiceProvider>> getAllServices(){
        return new ResponseEntity<List<ServiceProvider>>(serviceProviderService.allServiceProvider(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ServiceProvider>> getSpecificServiceProvider(@PathVariable ObjectId id){

        return new ResponseEntity<Optional<ServiceProvider>>(serviceProviderService.specificServiceProvider(id), HttpStatus.OK);
    }
}
