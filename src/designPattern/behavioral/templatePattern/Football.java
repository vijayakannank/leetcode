package designPattern.behavioral.templatePattern;

public class Football extends Game{
    @Override
    void initialize() {
        System.out.println("foot ball game is initialized");

    }

    @Override
    void start() {
        System.out.println("foot ball game is started");
    }

    @Override
    void stop() {
        System.out.println("foot ball game is stopped");
    }
}
