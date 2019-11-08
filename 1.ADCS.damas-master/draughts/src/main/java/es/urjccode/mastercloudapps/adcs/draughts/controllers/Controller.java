package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.Session;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;

public abstract class Controller {

	protected Session session;
	protected Game game;
	protected State state;

    protected Controller(Session session) {
		this.session = session;
	}
	
    protected Controller(Game game, State state) {
		this.game = game;
		this.state = state;
	}
	
    public Color getColor(Coordinate coordinate) {
		return this.session.game.getColor(coordinate);
	}

	public int getDimension() {
		return this.session.game.getDimension();
	}

	abstract public void accept(ControllersVisitor controllersVisitor);
    
}
