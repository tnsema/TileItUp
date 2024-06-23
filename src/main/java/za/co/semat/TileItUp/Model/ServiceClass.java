package za.co.semat.TileItUp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;


@Document(collection = "service")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceClass implements Serializable {

    @Id
    private ObjectId id;
    private String serviceName;
    private String description;
    private byte[] photo;
    private Instant creationDate;

    public ServiceClass(String name, String description, byte[] photo, Instant creationDate) {
        this.description = description;
        this.photo = photo;
        this.creationDate = creationDate;
    }
}
