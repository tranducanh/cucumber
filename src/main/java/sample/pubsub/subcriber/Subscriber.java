package sample.pubsub.subcriber;

import sample.pubsub.message.Message;
import sample.pubsub.service.PubSubService;

import java.util.ArrayList;
import java.util.List;

public abstract class Subscriber {
    private List<Message> subscriberMessages = new ArrayList<Message>();

    public abstract void addSubscriber(String topic, PubSubService pubSubService);

    public abstract void unSubscriberMessages(String topic, PubSubService pubSubService);

    public abstract void getMessageByTopic(String topic, PubSubService pubSubService);

    public void printMessages() {
        for (Message message : subscriberMessages) {
            System.out.println("Message Topic -> " + message.getTopic() + " : " + message.getPayload());
        }
    }

    public List<Message> getSubscriberMessages() {
        return subscriberMessages;
    }

    public void setSubscriberMessages(List<Message> subscriberMessages) {
        this.subscriberMessages = subscriberMessages;
    }
}
