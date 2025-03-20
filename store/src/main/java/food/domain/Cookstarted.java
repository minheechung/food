package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class Cookstarted extends AbstractEvent {

    private Long id;
    private String orderid;
    private String status;

    public Cookstarted(Cook aggregate) {
        super(aggregate);
    }

    public Cookstarted() {
        super();
    }
}
//>>> DDD / Domain Event
