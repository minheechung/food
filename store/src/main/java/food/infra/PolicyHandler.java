package food.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import food.config.kafka.KafkaProcessor;
import food.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    CookRepository cookRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Ordered'"
    )
    public void wheneverOrdered_OrderNoticed(@Payload Ordered ordered) {
        Ordered event = ordered;
        System.out.println(
            "\n\n##### listener OrderNoticed : " + ordered + "\n\n"
        );

        // Sample Logic //
        Cook.orderNoticed(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Ordercanceled'"
    )
    public void wheneverOrdercanceled_OrderNoticed(
        @Payload Ordercanceled ordercanceled
    ) {
        Ordercanceled event = ordercanceled;
        System.out.println(
            "\n\n##### listener OrderNoticed : " + ordercanceled + "\n\n"
        );

        // Sample Logic //
        Cook.orderNoticed(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
