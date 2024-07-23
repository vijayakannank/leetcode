package designPattern.structural.bridge;

public class BridgeDemo {

    public static void main(String[] args) {
        MessageSender textMessageSender=new TextMessageSender();
        Message textMessage=new TextMessage(textMessageSender);
        textMessage.sendMessage();
        MessageSender emailMessageSender=new EmailMessageSender();
        Message emailMessage=new EmailMessage(emailMessageSender);
        emailMessage.sendMessage();
    }
}
