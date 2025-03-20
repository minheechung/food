package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Ordercanceled extends AbstractEvent {

    private Long id;

    public Ordercanceled(Order aggregate) {
        super(aggregate);
    }

    public Ordercanceled() {
        super();
    }
}
//>>> DDD / Domain Event
