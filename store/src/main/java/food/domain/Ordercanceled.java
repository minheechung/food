package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Ordercanceled extends AbstractEvent {

    private Long id;
}
