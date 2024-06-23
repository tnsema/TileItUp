package za.co.semat.TileItUp.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import za.co.semat.TileItUp.Model.ServiceProvider;

@Repository
public interface ServiceProviderRepository2 extends MongoRepository<ServiceProvider, ObjectId> {
}
