package za.co.semat.TileItUp.Controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.co.semat.TileItUp.Model.ServiceClass;
import za.co.semat.TileItUp.Services.ServiceSevice;

import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    @Autowired
    private ServiceSevice serviceSevice;

    @GetMapping
    public ResponseEntity<List<ServiceClass>> getAllServices(){
        return new ResponseEntity<List<ServiceClass>>(serviceSevice.allServices(), HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ServiceClass>> getSingleService(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<ServiceClass>>(serviceSevice.singleMovie(id), HttpStatus.OK);
    }

    @PostMapping("/addservice")
    public ResponseEntity<ServiceClass> addService(@RequestParam("description") String name, @RequestParam("description") String description, @RequestParam("date") Instant date, @RequestParam("file") MultipartFile file) throws IOException {

        byte[] fileBytes = file.getBytes();

        return new ResponseEntity<ServiceClass>(serviceSevice.addService(name, description, fileBytes, date), HttpStatus.CREATED);
    }
}
