package controller.commands;

import java.util.ArrayList;
import javafx.beans.property.StringProperty;
import model.iModel;

/**
 * The Class MoveCommand - move a movable item from one position to another.
 */
public class MoveCommand extends Command
{
	private iModel model;
	private StringProperty countSteps;
	
	public MoveCommand(iModel model, StringProperty countSteps)
	{
		this.model = model;
		this.countSteps = countSteps;
	}

	@Override
	public void execute()
	{
		if(isValidMoveType(getParams()) == false)
			return;
		this.model.move(getParams());
		int steps = this.model.getSteps();
		this.countSteps.set(""+(steps));
	}
	
	/**
	 * IsValidMoveType - checking if a move type command is correct ot not.
	 * @param moveType
	 * @return
	 */
	private boolean isValidMoveType(String moveType)
	{
		ArrayList<String> moveList = new ArrayList<String>();
		moveList.add("up");
		moveList.add("down");
		moveList.add("right");
		moveList.add("left");
		
		if(moveList.contains(moveType.toLowerCase()) == true)
			return true;
		return false;
	}
}
