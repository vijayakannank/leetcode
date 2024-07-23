package designPattern.behavioral.Mediator;

public class User2 extends Participant {

    private String name;
    private ApnaChatRoom chat;

    @Override
    public void sendMsg(String msg,  Participant receiver) {
        System.out.println(this.name+" sends message to "+ receiver.getName());
        this.chat.sendMsg(msg,this,  receiver);
    }

    @Override
    public void receiveMsg(String msg, Participant participant) {
        System.out.println(this.name+" receives "+ msg+ " from "+participant.getName());
    }


    public String getName(){
        return this.name;
    }

    public User2(String name, ApnaChatRoom chat){
        this.chat=chat;
        this.name = name;
    }



}
