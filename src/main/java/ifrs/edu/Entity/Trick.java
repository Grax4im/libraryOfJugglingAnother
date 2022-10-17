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

public class Trick extends PanacheEntity{
    private String name;
    private int difficult;
    private int numberOfBalls;
    private String siteswap;
    private String description;
    private String preRequisites;
    private String image;
}
