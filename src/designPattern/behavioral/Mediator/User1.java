package designPattern.behavioral.Mediator;

public class User1 extends Participant {

    private String name;
    private ApnaChatRoom chat;


    @Override
    public void sendMsg(String msg,  Participant receiver) {
        System.out.println(this.name+" sends message to "+ receiver.getName());
        chat.sendMsg(msg,this, receiver);
    }


    @Override
    public void receiveMsg(String msg, Participant participant) {
        System.out.println(this.name+" receives "+ msg+ " from "+participant.getName());
    }

    public User1(String name, ApnaChatRoom chat){
        this.chat=chat;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}// End of the User1 class.
