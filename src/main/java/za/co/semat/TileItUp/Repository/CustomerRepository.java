package za.co.semat.TileItUp.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import za.co.semat.TileItUp.Model.Customer;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, ObjectId> {
    Optional<Customer> findByEmail(String email);
}
