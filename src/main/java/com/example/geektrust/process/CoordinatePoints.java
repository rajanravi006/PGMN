package com.example.geektrust.process;

import com.example.geektrust.modal.CoOrdinates;

public class CoordinatePoints {
	
	private CoOrdinates coOrdinates;
	
	public CoordinatePoints(CoOrdinates coOrdinates) {
		this.coOrdinates=coOrdinates;
	}

	public Integer calculateTotalPoints() {
		return Math.abs(coOrdinates.getDestinationY()-coOrdinates.getSourceY())
			  + Math.abs(coOrdinates.getDestinationX()-coOrdinates.getSourceX());
	}
	
}
