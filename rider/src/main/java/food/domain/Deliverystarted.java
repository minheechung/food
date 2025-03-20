package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Deliverystarted extends AbstractEvent {

    private Long id;
    private String orderId;
    private String address;
    private String status;

    public Deliverystarted(Delivery aggregate) {
        super(aggregate);
    }

    public Deliverystarted() {
        super();
    }
}
//>>> DDD / Domain Event
