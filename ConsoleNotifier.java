package TicTacToe;

public class ConsoleNotifier implements IObserver{
    @Override
    public void update(String msg) {
        System.out.println("[Notification]: "+msg);
    }
}
