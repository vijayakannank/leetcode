package designPattern.structural.bridge;

public class SmsSender extends Message{
    MessageSender sender;
    SmsSender(MessageSender sender){
        super(sender);
        this.sender = sender;

    }

    @Override
    void sendMessage() {
        sender.sendMessage();
    }
}
