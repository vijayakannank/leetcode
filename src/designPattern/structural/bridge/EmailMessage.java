package designPattern.structural.bridge;

public class EmailMessage extends Message{
    MessageSender sender;
    EmailMessage(MessageSender sender){
        super(sender);
        this.sender = sender;
    }

    @Override
    void sendMessage() {
        sender.sendMessage();
    }
}
