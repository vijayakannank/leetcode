package designPattern.behavioral.Mediator;

public abstract class Participant {
    public abstract void sendMsg(String msg, Participant receiver);

    public abstract void receiveMsg(String msg, Participant participant);

    public abstract String getName();
}