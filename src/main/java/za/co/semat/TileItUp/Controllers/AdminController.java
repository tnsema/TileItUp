package za.co.semat.TileItUp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.semat.TileItUp.Model.Admin;
import za.co.semat.TileItUp.Model.Customer;
import za.co.semat.TileItUp.Services.AdminService;
import za.co.semat.TileItUp.Services.FacinationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins(){

        return new ResponseEntity<List<Admin>>(adminService.allAdmin(), HttpStatus.OK);

    }

    @PostMapping("/login")
    public ResponseEntity<Optional<Admin>> adminlogin(@RequestParam("email") String email, @RequestParam("password") String password){

        Optional<Admin> a = adminService.login(email, password);



        return new ResponseEntity<Optional<Admin>>(a, HttpStatus.OK);
    }

}
