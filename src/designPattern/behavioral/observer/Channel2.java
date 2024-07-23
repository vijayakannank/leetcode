package designPattern.behavioral.observer;

public class Channel2 implements Channel{
    @Override
    public void update(String news) {
        System.out.println(news+" from channel 2");
    }
}
