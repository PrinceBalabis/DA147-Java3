import controller.DatabasKomController;
import controller.HuvudController;
import gui.HuvudFrame;

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
