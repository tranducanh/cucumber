package sample.pubsub.service;

import sample.pubsub.message.Message;
import sample.pubsub.subcriber.Subscriber;
import sample.pubsub.subcriber.SubscriberImpl;

import java.util.*;

public class PubSubService {
    //Keeps set of subscriber topic wise, using set to prevent duplicates
    Map<String, Set<Subscriber>> subscribersTopicMap = new HashMap<String, Set<Subscriber>>();

    //Holds messages published by publishers
    Queue<Message> messagesQueue = new LinkedList<Message>();

    public void addSubscriber(String topic, Subscriber subscriber) {
        if (subscribersTopicMap.containsKey(topic)) {
            Set<Subscriber> subscribers = subscribersTopicMap.get(topic);
            subscribers.add(subscriber);
            subscribersTopicMap.put(topic, subscribers);
        } else {
            Set<Subscriber> subscribers = new HashSet<Subscriber>();
            subscribers.add(subscriber);
            subscribersTopicMap.put(topic, subscribers);
        }
    }

    public void unSubscriber(String topic, Subscriber subscriber) {
        if (subscribersTopicMap.containsKey(topic)) {
            Set<Subscriber> subscribers = subscribersTopicMap.get(topic);
            subscribers.remove(subscriber);
            subscribersTopicMap.put(topic, subscribers);
        }
    }

    //Broadcast new messages added in queue to All subscribers of the topic. messagesQueue will be empty after broadcasting
    public void broadcast() {
        if (messagesQueue.isEmpty()) {
            System.out.println("No messages from publishers to display");
        } else {
            while (!messagesQueue.isEmpty()) {
                Message message = messagesQueue.remove();
                String topic = message.getTopic();

                Set<Subscriber> subscribersOfTopic = subscribersTopicMap.get(topic);

                for (Subscriber subscriber : subscribersOfTopic) {
                    //add broadcasted message to subscribers message queue
                    List<Message> subscriberMessages = subscriber.getSubscriberMessages();
                    subscriberMessages.add(message);
                    subscriber.setSubscriberMessages(subscriberMessages);
                }
            }
        }
    }


    public void getMessageByTopic(String topic, Subscriber subscriber) {
        if (messagesQueue.isEmpty()) {
            System.out.println("No messages from publishers to display");
        } else {
            while (!messagesQueue.isEmpty()) {
                Message message = messagesQueue.remove();

                if (message.getTopic().equalsIgnoreCase(topic)) {

                    Set<Subscriber> subscribersOfTopic = subscribersTopicMap.get(topic);

                    for (Subscriber _subscriber : subscribersOfTopic) {
                        if (_subscriber.equals(subscriber)) {
                            //add broadcasted message to subscriber message queue
                            List<Message> subscriberMessages = subscriber.getSubscriberMessages();
                            subscriberMessages.add(message);
                            subscriber.setSubscriberMessages(subscriberMessages);
                        }
                    }
                }
            }
        }
    }

    public void addMessageToQueue(Message message) {
        messagesQueue.add(message);
    }
}
