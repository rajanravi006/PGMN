package enums;

public enum GmanPoints {
	MAX_SCORE(200),
	GRID_POINTS(10),
	TURN_POINTS(5);
	
	public final Integer value;
	GmanPoints(Integer value) {
		this.value = value;
	}
}
