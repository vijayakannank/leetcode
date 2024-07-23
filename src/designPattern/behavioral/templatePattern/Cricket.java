package designPattern.behavioral.templatePattern;

public class Cricket extends Game{
    @Override
    void initialize() {
        System.out.println("Cricket game is initialized and going to start");
    }

    @Override
    void start() {
        System.out.println("Cricket game is started ");
    }

    @Override
    void stop() {
        System.out.println("Cricket game is stopped");
    }
}
