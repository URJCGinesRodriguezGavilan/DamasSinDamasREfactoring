package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class PlayView extends SubView {

    private static final String[] COLORS = {"blancas", "negras"};

    public PlayView(){
        super();
    }

    public void interact(PlayController playController) {
        String color = PlayView.COLORS[playController.getColor().ordinal()];
        Error error = null;
        GameView gameView = new GameView();
        do {
            String command = this.console.readString("Mueven las " + color + ": ");
            String[] numbers = command.split("\\n|\\.");
            Coordinate origin = new Coordinate(numbers[0]);
            Coordinate target = new Coordinate(numbers[1]);
            if (!origin.isValid() || !target.isValid()) {
                error =  Error.OUT_COORDINATE;
            } else {
                error = playController.move(origin, target);
            }
            if (error != null){
                console.writeln("Error!!!" + error.name());
                gameView.write(playController);
            }
        } while (error != null); 
        if (playController.isBlocked()){
            this.console.write(MessageView.YOU_LOSE.getMessage());
        }
    }

}