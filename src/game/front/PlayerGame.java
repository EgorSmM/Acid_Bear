package game.front;

public class PlayerGame extends Game{

    public PlayerGame(int dHealth, int dDist){

        super(dHealth, dDist);

        Controller controller = new Controller(frontBear.label);
        addKeyListener(controller);
        setFocusable(true);

        setVisible(true);
    }
}