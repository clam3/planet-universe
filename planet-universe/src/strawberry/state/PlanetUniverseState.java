package strawberry.state;

public class PlanetUniverseState {
	
	private static GameState gameState;

	public static GameState getGameState() {
		return gameState;
	}

	public static void setGameState(GameState gameState) {
		PlanetUniverseState.gameState = gameState;
	}
}
