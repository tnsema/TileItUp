package za.co.semat.TileItUp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.io.Serializable;
import java.time.Instant;

@Document(collection = "Facination")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facination implements Serializable {
    @Id
    private ObjectId id;
    @DocumentReference
    private ServiceClass serviceId;
    @DocumentReference
    private Customer customerId;
    @DocumentReference
    private ServiceProvider serviceProviderId;
    private Instant creationDate;

    public Facination(ServiceClass serviceId, Customer customerId, ServiceProvider serviceProviderId, Instant creationDate) {
        this.serviceId = serviceId;
        this.customerId = customerId;
        this.serviceProviderId = serviceProviderId;
        this.creationDate = creationDate;
    }

    public Facination(ServiceClass serviceId, Customer customerId, Instant creationDate) {
        this.serviceId = serviceId;
        this.customerId = customerId;
        this.creationDate = creationDate;
    }
}
