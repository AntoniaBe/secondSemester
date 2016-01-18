package src;


import java.util.Random;

public class RandomWait {

	private static Random random = new Random(System.currentTimeMillis());

	public static synchronized void waitRandom() {
		long millis = (long) (random.nextDouble() * 5000);

		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
