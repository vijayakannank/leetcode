package designPattern.behavioral.State;

public class SurvivalState implements PlayerState {
    @Override
    public void action(Player p) {
        p.survive();
        p.firePistol();
    }
}
