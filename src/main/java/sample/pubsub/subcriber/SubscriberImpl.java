package sample.pubsub.subcriber;

import sample.pubsub.service.PubSubService;

public class SubscriberImpl extends Subscriber {
    @Override
    public void addSubscriber(String topic, PubSubService pubSubService) {
        pubSubService.addSubscriber(topic, this);

    }

    @Override
    public void unSubscriberMessages(String topic, PubSubService pubSubService) {
        pubSubService.unSubscriber(topic, this);

    }

    @Override
    public void getMessageByTopic(String topic, PubSubService pubSubService) {
        pubSubService.getMessageByTopic(topic, this);
    }
}
