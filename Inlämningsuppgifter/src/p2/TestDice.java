package p2;

/**
 * Klassen är till för att testa tärnkastningar både lokalt och av typer av spelare
 * som OrdinaryPlayer och Cheater.
 * @author Prince Balabis, AB7271
 *
 */
public class TestDice {
	
	/**
	 * Tar emot ett Dice-objekt och gör antalt bestämda tärnkastningar.
	 * @param dice Dice-objekt
	 * @param nbrOfThrows Antal tärnkastningar
	 */
	public static void test( Dice dice, int nbrOfThrows){
		int[] res = new int[dice.getSides()];
		
		// Count number of sides thrown
		for (int i = 0; i < nbrOfThrows; i++) {
			res[dice.throwDice()-1] += 1;
		}
		
		// Print results
		for (int i = 0; i < dice.getSides(); i++) {
			System.out.println(i+1+" "+res[i]);
		}
		
	}
	
	/**
	 * Tar emot Player-objekt och gör ett bestämt antal tärnkastningar.
	 * @param player Player-objekt som ska göra tärnkastningarna
	 * @param nbrOfThrows Antal tärnkastningar
	 */
	public static void test( Player player, int nbrOfThrows ){
		Dice dice;
		if(player instanceof OrdinaryPlayer){ // This happens if Player is an OrdinaryPlayer
			System.out.println("Ordinary-player");
			OrdinaryPlayer ordinaryPlayer = (OrdinaryPlayer) player;
			dice = ordinaryPlayer.getDice();
			int[] res = new int[dice.getSides()];
			// Count number of sides thrown
			for (int i = 0; i < nbrOfThrows; i++) {
				res[ordinaryPlayer.throwDice()-1] += 1;
			}
			// Print results
			for (int i = 0; i < dice.getSides(); i++) {
				System.out.println(i+1+" "+res[i]);
			}
		} else {
			System.out.println("Cheater-player"); // This happens if Player is a Cheater
			Cheater cheaterPlayer = (Cheater) player;
			dice = cheaterPlayer.getDice();
			int[] res = new int[dice.getSides()];
			// Count number of sides thrown
			for (int i = 0; i < nbrOfThrows; i++) {
				res[cheaterPlayer.throwDice()-1] += 1;
			}
			// Print results
			for (int i = 0; i < dice.getSides(); i++) {
				System.out.println(i+1+" "+res[i]);
			}
		}
	}
	
	public static void main(String[] args){
//		TestDice.test(new SimpleDice(6), 1000000);
//		System.out.println();
//		TestDice.test(new SimpleDice(4), 1000000);
		
		TestDice.test( new OrdinaryPlayer( "Rut", new SimpleDice( 6 ) ), 1000000 );
		System.out.println();
		TestDice.test( new Cheater( "Fuffe", new SimpleDice( 6 ) ), 1000000 );
	}
}
