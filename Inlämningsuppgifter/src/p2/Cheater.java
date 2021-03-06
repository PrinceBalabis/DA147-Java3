package p2;

/**
 * Ärver Player. En fusk-spelare som kastar med 1 prick mer hälften av gångerna han kastar tärningen.
 * @author Prince
 *
 */
public class Cheater extends Player{
	private Dice dice;

	/**
	 * Tar emot namnet på spelaren
	 * @param name Namnet på spelaren
	 */
	public Cheater(String name) {
		super(name);
		dice = new SimpleDice();
	}

	/**
	 * Tar emot namn och Dice-objekt
	 * @param name Namnet på spelaren
	 * @param dice Dice-objekt
	 */
	public Cheater(String name, Dice dice) {
		super(name);
		this.dice = dice;
	}

	/**
	 * Kastar en tärning. Returnerar ett int värde på ett intervall mellan 1 till max antal tärnsidor.
	 * Hälften av tärnkastningarna har ett prick mer om inte det redan är högsta prick-värdet.
	 */
	@Override
	public int throwDice() {
		int sideThrown = dice.throwDice();
		if(sideThrown != dice.getSides()){
			sideThrown += (int)(Math.random()*2); // Hälften av gångerna som tärningen är kastad och prickarna är inte högst, läggs en extra prick till.
		}
		return sideThrown;
	}

	/**
	 * Bestämmer en tärning för fuskaren
	 * @param dice Dice-objekt
	 */
	public void setDice(Dice dice) {
		this.dice = dice;
	}

	/**
	 * Returnerar Dice-objekt
	 * @return Dice-objekt
	 */
	public Dice getDice() {
		return dice;
	}

	public static void main(String[] args) {
		Player player1 = new OrdinaryPlayer( "Viktor",new SimpleDice(6) );
		Player player2 = new Cheater( "Signe", new SimpleDice(6) );
		Game game = new Game( player1, player2 );
		System.out.println( "\nResultatet av tio spel" );
		for( int i=0; i<10; i++ )
			game.play( false );	
	}

}
