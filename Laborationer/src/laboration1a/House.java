package laboration1a;

public class House {

	private double area;
	private int nbrOfRooms;

	public void setArea(double area) {
		this.area = area;
	}

	public void setNbrOfRooms(int nbrOfRooms) {
		this.nbrOfRooms = nbrOfRooms;
	}

	public double getArea() {
		return area;
	}

	public int getNbrOfRooms() {
		return nbrOfRooms;
	}

	public String toString(){
		String stringToReturn = "Bostad med ytan "+ getArea() +" m2 och "+ getNbrOfRooms() +" rum.";
		return stringToReturn;
	}

	public static void main(String[] args){
		House house1 = new House();
		House house2 = new House();
		house1.setArea(55);
		house1.setNbrOfRooms(2);
		house2.setArea(108.6);
		house2.setNbrOfRooms(4);
		System.out.println(house1.toString());
		System.out.println("Yta: " + house2.getArea() + " m2" +
				"  Antal rum: " + house2.getNbrOfRooms());
	}

}