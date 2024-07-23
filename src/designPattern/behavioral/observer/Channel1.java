package designPattern.behavioral.observer;

public class Channel1 implements Channel{
    @Override
    public void update(String news) {
        System.out.println(news+" from channel 1");
    }
}
