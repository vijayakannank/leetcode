package designPattern.behavioral.observer;

public class ObserverDemo {

    public static void main(String[] args) {
        NewsAgency observable = new NewsAgency();

        Channel1 observer1 = new Channel1();
        Channel2 observer2 = new Channel2();

        observable.setChannels(observer1);
        observable.setChannels(observer2);

        observable.notify("this is sports news");
    }
}
