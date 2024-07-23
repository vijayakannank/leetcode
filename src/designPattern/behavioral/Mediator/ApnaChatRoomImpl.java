package designPattern.behavioral.Mediator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApnaChatRoomImpl implements ApnaChatRoom{
    @Override
    public void sendMsg(String msg, Participant sender, Participant receiver) {
        receiver.receiveMsg(msg, sender);

    }
}// End of the ApnaChatRoomImpl class.