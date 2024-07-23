package designPattern.behavioral.Mediator;

public class MediatorPatternDemo {

    public static void main(String args[])
    {

        ApnaChatRoom chat = new ApnaChatRoomImpl();

       Participant user1 = new User1("Vijay", chat);

       Participant user2= new User2("Kannan", chat);

       user1.sendMsg("Hi", user2);
       user2.sendMsg("Hi", user1);
    }

}
