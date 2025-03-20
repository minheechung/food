package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Orderaccepted extends AbstractEvent {

    private Long id;
    private String orderid;
    private String status;

    public Orderaccepted(Cook aggregate) {
        super(aggregate);
    }

    public Orderaccepted() {
        super();
    }
}
//>>> DDD / Domain Event
