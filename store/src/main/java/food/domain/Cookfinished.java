package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Cookfinished extends AbstractEvent {

    private Long id;
    private String orderid;

    public Cookfinished(Cook aggregate) {
        super(aggregate);
    }

    public Cookfinished() {
        super();
    }
}
//>>> DDD / Domain Event
