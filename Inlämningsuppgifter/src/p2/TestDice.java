package p2;

public class TestDice {
	
	public static void test( Dice dice, int nbrOfThrows){
		int[] res = new int[dice.getSides()];
		
		// Count number of sides thrown
		for (int i = 0; i < nbrOfThrows; i++) {
			res[dice.throwDice()] += 1;
		}
		
		// Print results
		for (int i = 0; i < dice.getSides(); i++) {
			System.out.println(i+" "+res[dice.throwDice()]);
		}
		
	}
	
	public static void main(String[] args){
		TestDice.test(new SimpleDice(6), 1000000);
		System.out.println();
		TestDice.test(new SimpleDice(4), 1000000);
	}
}
