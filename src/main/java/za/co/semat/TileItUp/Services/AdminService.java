package za.co.semat.TileItUp.Services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.semat.TileItUp.Model.Admin;
import za.co.semat.TileItUp.Model.Customer;
import za.co.semat.TileItUp.Repository.AdminRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> allAdmin(){
        return adminRepository.findAll();
    }

    public Admin delete(ObjectId id){

        Optional<Admin> admin = adminRepository.findById(id);

        Admin a = admin.orElseThrow(() -> new RuntimeException("Service not found is not present"));

        adminRepository.delete(a);

        return a;
    }

    public Optional<Admin> login(String email, String password) {

        Optional<Admin> a = adminRepository.findByEmail(email);

        if (a.isPresent()) {
            Admin admin = a.get();
            if (admin.getPassword().equals(password)) { // Check if the password matches
                return Optional.of(admin); // Return Optional containing the customer
            } else {
                // Incorrect password
                return Optional.empty(); // Return an empty Optional
            }
        } else {
            return Optional.empty();
        }
    }

}
