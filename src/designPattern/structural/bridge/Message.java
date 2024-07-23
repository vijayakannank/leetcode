package designPattern.structural.bridge;

public abstract class Message {

    MessageSender messageSender;

    Message(MessageSender sender){
        this.messageSender = sender;
    }

    abstract void sendMessage();
}
