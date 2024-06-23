package za.co.semat.TileItUp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "serviceProvider")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProvider {
    @Id
    private ObjectId id;

    private String name;
    private String surname;
}
