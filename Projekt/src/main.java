import controller.HuvudController;

public class main {

	public static void main(String[] args) {
		// Starta HuvudController
		new Runnable() {
			public void run() {
				new HuvudController();
			}
		}.run();
	}
}
