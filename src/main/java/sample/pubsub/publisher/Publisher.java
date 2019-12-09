package sample.pubsub.publisher;

import sample.pubsub.message.Message;
import sample.pubsub.service.PubSubService;

public interface Publisher {
    //Publishes new message to PubSubService
    void publish(Message message, PubSubService pubSubService);
}
