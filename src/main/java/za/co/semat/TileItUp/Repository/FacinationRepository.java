package za.co.semat.TileItUp.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import za.co.semat.TileItUp.Model.Customer;
import za.co.semat.TileItUp.Model.Facination;
import za.co.semat.TileItUp.Model.ServiceClass;

import java.util.Optional;

@Repository
public interface FacinationRepository extends MongoRepository<Facination, ObjectId> {
    Optional<Facination> findByCustomerIdAndServiceId(Customer customer, ServiceClass serviceClass);
}
