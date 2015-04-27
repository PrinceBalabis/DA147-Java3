package laboration1a;

public class Employee {
	private String name;
	private String employer;
	private double wage;

	public void setName(String name){
		this.name = name;
	}

	public void setEmployer(String employer){
		this.employer = employer;
	}

	public void setWage(double wage){
		this.wage = wage;
	}

	public String getName(){
		return this.name;
	}

	public String getEmployer(){
		return this.employer;
	}

	public double getWage(){
		return this.wage;
	}

	public static void main(String[] args){
		// Den f�rsta anst�llda skapas
		Employee e1=new Employee();
		e1.setName("Anna Olsson");
		e1.setEmployer("Eriksson");
		e1.setWage(25700);
		// Den andra anst�llda skapas
		Employee e2=new Employee();
		e2.setName("Pontus Persson");
		e2.setEmployer("Malm� h�gskola");
		e2.setWage(23900);
		//De anst�llda skrivs ut
		System.out.println();
		System.out.println(e1.getName()+ " har anst�llning hos " + 
				e1.getEmployer() + " med l�nen " + e1.getWage() + ".");
		System.out.println(e2.getName()+ " har anst�llning hos " + 
				e2.getEmployer() + " med l�nen " + e2.getWage() + ".");

	}
}

