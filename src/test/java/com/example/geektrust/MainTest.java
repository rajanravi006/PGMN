package com.example.geektrust;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.geektrust.modal.CoOrdinates;
import com.example.geektrust.process.CoordinatePoints;
import com.example.geektrust.process.PowerLoss;
import com.example.geektrust.process.Turn;

class MainTest {

	@Test
	void calculateTurnTest() {

		CoOrdinates coOrdinates = new CoOrdinates(5, 5, 3, 3, "N");
		Turn calculateTurns = new Turn(coOrdinates);
		Integer outputTurn = calculateTurns.calculateTurn();

		Assertions.assertEquals(2, outputTurn);
	}

	@Test
	void calculateTurnTest2() {

		CoOrdinates coOrdinates = new CoOrdinates(0, 0, 6, 6, "W");
		Turn calculateTurns = new Turn(coOrdinates);
		Integer outputTurn = calculateTurns.calculateTurn();

		Assertions.assertEquals(2, outputTurn);
	}

	@Test
	void calculateTurnTest3() {

		CoOrdinates coOrdinates = new CoOrdinates(3, 1, 5, 1, "W");
		Turn calculateTurns = new Turn(coOrdinates);
		Integer outputTurn = calculateTurns.calculateTurn();

		Assertions.assertEquals(2, outputTurn);
	}

	@Test
	void calculateTotalPointsTest() {

		CoOrdinates coOrdinates = new CoOrdinates(3, 1, 5, 1, "W");
		CoordinatePoints calculateGrid = new CoordinatePoints(coOrdinates);
		Integer outputTurn = calculateGrid.calculateTotalPoints();

		Assertions.assertEquals(2, outputTurn);
	}
	
	@Test
	void calculateTotalPointsTest2() {

		CoOrdinates coOrdinates = new CoOrdinates(0, 0, 6, 6, "W");
		CoordinatePoints calculateGrid = new CoordinatePoints(coOrdinates);
		Integer outputTurn = calculateGrid.calculateTotalPoints();

		Assertions.assertEquals(12, outputTurn);
	}
	
	@Test
	void resultantTest() {

		CoOrdinates coOrdinates = new CoOrdinates(3, 1, 5, 1, "W");
		Turn calculateTurns = new Turn(coOrdinates);
		CoordinatePoints calculateGrid = new CoordinatePoints(coOrdinates);
		PowerLoss powerLoss = new PowerLoss(calculateGrid, calculateTurns);
		Integer power = powerLoss.resultant();

		Assertions.assertEquals(170, power);
	}
	
	@Test
	void resultantTest2() {

		CoOrdinates coOrdinates = new CoOrdinates(0, 0, 6, 6, "W");
		Turn calculateTurns = new Turn(coOrdinates);
		CoordinatePoints calculateGrid = new CoordinatePoints(coOrdinates);
		PowerLoss powerLoss = new PowerLoss(calculateGrid, calculateTurns);
		Integer power = powerLoss.resultant();

		Assertions.assertEquals(70, power);
	}
	
	@Test
	void isCoordinateGreaterTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Method method = Turn.class.getDeclaredMethod("isCoordinateGreater", Integer.class, Integer.class);
		method.setAccessible(true);
		CoOrdinates coOrdinates = new CoOrdinates(0, 0, 6, 6, "W");
		Turn turn = new Turn(coOrdinates);
		Boolean output = (Boolean) method.invoke(turn, 0, 6);
		Assertions.assertEquals(false, output);
	}
	
	@Test
	void notFacingNorthLiesInSouthTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Method method = Turn.class.getDeclaredMethod("notFacingNorthLiesInSouth");
		method.setAccessible(true);
		CoOrdinates coOrdinates = new CoOrdinates(0, 0, 6, 6, "W");
		Turn turn = new Turn(coOrdinates);
		Boolean output = (Boolean) method.invoke(turn);
		Assertions.assertEquals(true, output);
	}
	
	@Test
	void notFacingSouthLiesInNorthTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Method method = Turn.class.getDeclaredMethod("notFacingSouthLiesInNorth");
		method.setAccessible(true);
		CoOrdinates coOrdinates = new CoOrdinates(0, 0, 6, 7, "W");
		Turn turn = new Turn(coOrdinates);
		Boolean output = (Boolean) method.invoke(turn);
		Assertions.assertEquals(false, output);
	}
	
	@Test
	void notFacingWestLiesInEastTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Method method = Turn.class.getDeclaredMethod("notFacingWestLiesInEast");
		method.setAccessible(true);
		CoOrdinates coOrdinates = new CoOrdinates(0, 1, 6, 6, "W");
		Turn turn = new Turn(coOrdinates);
		Boolean output = (Boolean) method.invoke(turn);
		Assertions.assertEquals(false, output);
	}
	
	@Test
	void notFacingEastLiesInWestTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Method method = Turn.class.getDeclaredMethod("notFacingEastLiesInWest");
		method.setAccessible(true);
		CoOrdinates coOrdinates = new CoOrdinates(0, 0, 6, 6, "W");
		Turn turn = new Turn(coOrdinates);
		Boolean output = (Boolean) method.invoke(turn);
		Assertions.assertEquals(true, output);
	}

}
