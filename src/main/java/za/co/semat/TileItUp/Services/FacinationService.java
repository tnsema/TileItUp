package za.co.semat.TileItUp.Services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.semat.TileItUp.Model.Customer;
import za.co.semat.TileItUp.Model.Facination;
import za.co.semat.TileItUp.Model.ServiceClass;
import za.co.semat.TileItUp.Model.ServiceProvider;
import za.co.semat.TileItUp.Repository.CustomerRepository;
import za.co.semat.TileItUp.Repository.FacinationRepository;
import za.co.semat.TileItUp.Repository.ServiceProviderRepository2;
import za.co.semat.TileItUp.Repository.ServiceReprository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class FacinationService {

    @Autowired
    private FacinationRepository facinationRepository;
    @Autowired
    private ServiceReprository serviceReprository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ServiceProviderRepository2 serviceProviderRepository2;

    public List<Facination> allFacination(){

        return facinationRepository.findAll();
    }


    public void addFacination(ObjectId serviceId, ObjectId customerId, Instant date){

        Optional<ServiceClass> serviceClass = serviceReprository.findById(serviceId);
        ServiceClass sf = serviceClass.orElseThrow(() -> new RuntimeException("Service not found is not present"));

        Optional<Customer> customer = customerRepository.findById(customerId);
        Customer c = customer.orElseThrow(() -> new RuntimeException("Customer not found is not present"));


        //Optional<ServiceProvider> serviceProvider = serviceProviderRepository2.findById(serviceProviderId);
        //ServiceProvider sp = serviceProvider.orElseThrow(() -> new RuntimeException("ServiceProvider not found is not present"));


        Facination f = new Facination(sf, c, date);

        facinationRepository.save(f);

    }

    public boolean isFacinationCreated(ObjectId customerId, ObjectId serviceId, Instant date){

        Optional<Customer> c = customerRepository.findById(customerId);
        Customer customer = c.orElseThrow(() -> new RuntimeException("Customer is not present"));
        Optional<ServiceClass> sc = serviceReprository.findById(serviceId);
        ServiceClass serviceClass = sc.orElseThrow(() -> new RuntimeException("Service is not present"));

        Optional<Facination> f = facinationRepository.findByCustomerIdAndServiceId(customer,serviceClass);
        //Facination facination = f.orElseThrow(() -> new RuntimeException("Facination is not present"));

        if (!f.isPresent()){

            Facination fc = new Facination(serviceClass, customer, Instant.now());
            facinationRepository.save(fc);
            return false;
        }else {
            //Facination facination = f.orElseThrow(() -> new RuntimeException("Facination is not present"));
            facinationRepository.delete(f.get());
            return true;
        }
    }

    public void removeFacinaion(ObjectId id){

        Optional<Facination> f = facinationRepository.findById(id);
        Facination facination = f.orElseThrow(() -> new RuntimeException("Facination is not present"));

        facinationRepository.delete(facination);
    }

}
