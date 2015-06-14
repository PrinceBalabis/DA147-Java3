package p2;

/**
 * Klassen implementerar Dice. 
 * En simpel tärning man kan bestämma antalet sidor på.
 * @author Prince Balabis, AB7271
 */
public class SimpleDice implements Dice{
	private int sides;
	
    /**
     * Skapar en 6-sidig tärning
     **/
	public SimpleDice(){
		sides = 6;
	}
	
    /**
     * Skapar en tärning med så många sidor som anges av argumentet.
     * @param sides Antal sidor på tärningen. Antalet sidor måste vara större 
     * än 0.
     * @throws NegativeSidesException Om värdet på <code>sides</code> är mindre eller
     *                                lika med 0
     **/
	public SimpleDice(int sides){
		if(sides < 1)
				throw new NegativeSidesException("Tärningen måste ha minst 1 sida: "+sides);
		this.sides = sides;
	}
	
    /**
     * Returnerar resultatet av ett tärningskast. Resultatet är altid i intervallet
     * 1 till max antal sidor.
     **/
	@Override
	public int throwDice() {
		return (int)(Math.random()*sides+1);
	}
	
    /**
     * Returnerar antalet sidor på tärningen
     * @return Antalet sidor på tärningen
     **/
	@Override
	public int getSides() {
		return sides;
	}
	
	// Test of this class
	public static void main(String[] args){
		SimpleDice simpledice = new SimpleDice();
		System.out.println(simpledice.throwDice());
	}
	

}
