package designPattern.behavioral.templatePattern;

public abstract class Game {

    abstract void  initialize();
    abstract void start();

    abstract void stop();

    void play(){
        initialize();
        start();
        stop();
    }

}
