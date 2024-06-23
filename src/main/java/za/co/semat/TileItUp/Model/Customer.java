package za.co.semat.TileItUp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    @Id
    private ObjectId id;

    private String name;
    @Indexed(unique = true)
    private String email;
    private String password;
    private String surname;
    private String gender;
    private List<String> address;

    public Customer(String name, String email, String password, String surname, String gender, List<String> address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.surname = surname;
        this.gender = gender;
        this.address = address;
    }
}
