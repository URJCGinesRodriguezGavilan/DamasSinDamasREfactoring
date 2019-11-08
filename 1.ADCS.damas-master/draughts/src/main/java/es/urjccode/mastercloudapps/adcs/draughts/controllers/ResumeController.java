package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.Session;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;

public class ResumeController extends Controller {

	public ResumeController(Session session) {
        super(session);
    }

	public ResumeController(Game game, State state) {
        super(game, state);
	}
	
    @Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

	public void next() {
        this.session.state.next();
	}

	public void reset() {
        this.session.state.reset();
	}

}
