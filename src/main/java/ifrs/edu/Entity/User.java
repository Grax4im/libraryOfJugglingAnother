package ifrs.edu.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class User extends PanacheEntity{
    
    private String name;
    private String password;
    private String email;
    //0 for adm -- 1 for creator
    private int type;

}
