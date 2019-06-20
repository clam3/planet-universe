package strawberry.state;

/**
 * Group of constants (possible states of the game)
 *
 */
public enum GameState {
	LOADING_MENU,
	MAIN_MENU,
	LOADING_CREDIT_MENU,
	CREDIT_MENU,
	LEVEL_TRANSITION, //fancy word for loading :P
	IN_UNIVERSE,
	IN_UNIVERSE_PAUSE
}
