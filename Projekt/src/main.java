import controller.HuvudController;

/**
 * Main-metoden som körs vid programstart - Startar HuvudController i en ny tråd
 * @author Prince
 *
 */
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
