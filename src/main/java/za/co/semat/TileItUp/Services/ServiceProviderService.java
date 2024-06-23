package za.co.semat.TileItUp.Services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.semat.TileItUp.Repository.ServiceProviderRepository2;
import za.co.semat.TileItUp.Model.ServiceProvider;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProviderService {

    @Autowired
    private ServiceProviderRepository2 serviceProviderRepository;

    public List<ServiceProvider> allServiceProvider(){

        return serviceProviderRepository.findAll();
    }

    public Optional<ServiceProvider> specificServiceProvider(ObjectId id){
        return serviceProviderRepository.findById(id);
    }

}
