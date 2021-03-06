package p2;

/**
 * Klassen ärver Player. 
 * En typisk spelare i tärningsspel.
 * @author Prince Balabis, AB7271
 */
public class OrdinaryPlayer extends Player{
	private Dice dice;
	
	/**
	 * Konstruktor som skapar en typisk spelare.
	 * @param name Namnet på spelaren.
	 */
	public OrdinaryPlayer(String name) {
		super(name);
		dice = new SimpleDice();
	}
	
	/**
	 * Konstruktor som skapar en typisk spelare. Tar även emot en Dice-objekt
	 * @param name Namnet på spelaren.
	 * @param dice Dice objekt.
	 */
	public OrdinaryPlayer(String name, Dice dice) {
		super(name);
		this.dice = dice;
	}
	
	/**
	 * Kastar tärningen.
	 * @return Returnerar ett int med intervallet 1 till max antal sidor av tärningen.
	 */
	@Override
	public int throwDice() {
		return dice.throwDice();
	}
	
	/**
	 * Används för att byta tärning till spelaren
	 * @param dice Dice objekt
	 */
	public void setDice(Dice dice) {
		this.dice = dice;
	}

	/**
	 * Returnerar dice-objektet som spelare äger
	 * @return Dice objekt
	 */
	public Dice getDice() {
		return dice;
	}
	

	public static void main(String[] args) {
		SimpleDice dice = new SimpleDice( 6 );
		Player player1 = new OrdinaryPlayer( "Gustav", dice );
		Player player2 = new OrdinaryPlayer( "Valborg", dice );
		Game game = new Game( player1, player2 );
		game.play( true );
	}
}
