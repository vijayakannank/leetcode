package designPattern.behavioral.templatePattern;

public class TemplatePatternDemo {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();

        Game game1 = new Football();
        game1.play();
    }
}
