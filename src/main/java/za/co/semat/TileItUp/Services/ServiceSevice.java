package za.co.semat.TileItUp.Services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.semat.TileItUp.Model.ServiceClass;
import za.co.semat.TileItUp.Repository.ServiceReprository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceSevice {

    @Autowired
    private ServiceReprository serviceReprository;

    public List<ServiceClass> allServices(){
       return serviceReprository.findAll();
    }

    public Optional<ServiceClass> singleMovie(ObjectId id){
        return serviceReprository.findById(id);
    }

    public ServiceClass addService(String name, String description, byte[] photo, Instant date){
        ServiceClass s = serviceReprository.insert(new ServiceClass(name,description,photo,date));

        return s;
    }
}
