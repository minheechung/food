package food.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "ViewOrder_table")
@Data
public class ViewOrder {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
