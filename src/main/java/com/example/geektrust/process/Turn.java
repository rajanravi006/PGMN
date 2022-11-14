package com.example.geektrust.process;

import com.example.geektrust.modal.CoOrdinates;
import com.example.geektrust.service.Turns;

public class Turn implements Turns {

	private Integer turns;
	private CoOrdinates cOrdinates;
	private String North = "N";
	private String South = "S";
	private String West = "W";
	private String East = "E";
	public Turn(CoOrdinates cOrdinates) {
		this.cOrdinates = cOrdinates;
		this.turns = 0;
	}
	
	private Boolean isCoordinateGreater(Integer x, Integer y) {
		return x > y ? true : false;
	}
	
	private Boolean notFacingNorthLiesInSouth() {
		return (isCoordinateGreater(cOrdinates.getDestinationY(), cOrdinates.getSourceY()) && !isFacingNorth());
	}
	
	private Boolean notFacingSouthLiesInNorth() {
		return (isCoordinateGreater(cOrdinates.getSourceY(), cOrdinates.getDestinationY()) && !isFacingSouth());
	}
	
	private Boolean notFacingWestLiesInEast() {
		return (isCoordinateGreater(cOrdinates.getSourceX(), cOrdinates.getDestinationX()) && !isFacingWest());
	}
	
	private  boolean notFacingEastLiesInWest() {
		return (isCoordinateGreater(cOrdinates.getDestinationX(), cOrdinates.getSourceX()) && !isFacingEast());
	}
	
	public Integer calculateTurn() {
		if ((notFacingNorthLiesInSouth() && isFacingSouth()) || (notFacingNorthLiesInSouth() && westFacingLiesInWest()) 
				|| (notFacingNorthLiesInSouth() && eastFacingLiesInEast()) || (notFacingSouthLiesInNorth() && westFacingLiesInWest()) 
				|| (notFacingSouthLiesInNorth() && isFacingNorth()) || (notFacingSouthLiesInNorth() && eastFacingLiesInEast()) 
				|| (notFacingWestLiesInEast() && isFacingEast()) || (notFacingEastLiesInWest() && isFacingWest())) 
		turns = turns + 2;
		else
		turns = turns + 1;
		
		return turns;
				
	}

	private boolean eastFacingLiesInEast() {
		return isCoordinateGreater(cOrdinates.getSourceX(), cOrdinates.getDestinationX()) && isFacingEast();
	}

	private boolean westFacingLiesInWest() {
		return isCoordinateGreater(cOrdinates.getDestinationX(), cOrdinates.getSourceX()) && isFacingWest();
	}

	private boolean isFacingWest() {
		return (cOrdinates.getDirection().equals(West));
	}

	private boolean isFacingEast() {
		return (cOrdinates.getDirection().equals(East));
	}

	private boolean isFacingNorth() {
		return (cOrdinates.getDirection().equals(North));
	}

	private boolean isFacingSouth() {
		return (cOrdinates.getDirection().equals(South));
	}

	
}
