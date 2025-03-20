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
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Orderaccepted'"
    )
    public void wheneverOrderaccepted_UpdateStatus(
        @Payload Orderaccepted orderaccepted
    ) {
        Orderaccepted event = orderaccepted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + orderaccepted + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Orderrejected'"
    )
    public void wheneverOrderrejected_UpdateStatus(
        @Payload Orderrejected orderrejected
    ) {
        Orderrejected event = orderrejected;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + orderrejected + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Cookstarted'"
    )
    public void wheneverCookstarted_UpdateStatus(
        @Payload Cookstarted cookstarted
    ) {
        Cookstarted event = cookstarted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + cookstarted + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Cookfinished'"
    )
    public void wheneverCookfinished_UpdateStatus(
        @Payload Cookfinished cookfinished
    ) {
        Cookfinished event = cookfinished;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + cookfinished + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Deliverystarted'"
    )
    public void wheneverDeliverystarted_UpdateStatus(
        @Payload Deliverystarted deliverystarted
    ) {
        Deliverystarted event = deliverystarted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + deliverystarted + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Deliverycompleted'"
    )
    public void wheneverDeliverycompleted_UpdateStatus(
        @Payload Deliverycompleted deliverycompleted
    ) {
        Deliverycompleted event = deliverycompleted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + deliverycompleted + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
