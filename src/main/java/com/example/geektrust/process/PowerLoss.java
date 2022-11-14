package com.example.geektrust.process;

import enums.GmanPoints;

public class PowerLoss {
	private CoordinatePoints totalPoints;
	private Turn turn;
	private Integer result;
	
	
	public PowerLoss(CoordinatePoints coordinatePoints, Turn turn) {
		this.result=0;
		this.totalPoints=coordinatePoints;
		this.turn=turn;
	}
	
	public Integer resultant() {
		result = GmanPoints.MAX_SCORE.value - (totalPoints.calculateTotalPoints()*GmanPoints.GRID_POINTS.value)
				                                          - (turn.calculateTurn()*GmanPoints.TURN_POINTS.value);
		
		return result;
	}

}
