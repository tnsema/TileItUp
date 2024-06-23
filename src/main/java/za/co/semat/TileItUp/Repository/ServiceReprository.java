package za.co.semat.TileItUp.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import za.co.semat.TileItUp.Model.ServiceClass;

import java.time.Instant;

@Repository
public interface ServiceReprository extends MongoRepository<ServiceClass, ObjectId> {

    ServiceClass findByCreationDate(Instant date);

}
