package designPattern.behavioral.State;

public class DeadState implements PlayerState {
    @Override
    public void action(Player p) {
        p.dead();
    }
}