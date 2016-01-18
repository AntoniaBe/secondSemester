package src;

public class PhilosopherDeadlock extends Philosopher {

	public PhilosopherDeadlock(String name) {
		super(name);

	}

	private Fork leftFork;
	private Fork rightFork;

	public void run() {

		while (true) {
			// not hungry, waiting
			Logger.printOut("Philosopher " + getName() + " is waiting.");
			// waiting();

			// hungry
			Logger.printOut("Philosopher " + getName() + " is hungry.");
			Logger.printOut("Philosopher " + getName() + " grabs left fork.");
			leftFork.take(this);
			Logger.printOut("Philosopher " + getName() + " grabs right fork.");
			rightFork.take(this);

			// eating
			Logger.printOut("Philosopher " + getName() + " is eating.");
			// eating();
			Logger.printOut("Philosopher " + getName()
					+ " is not hungry anymore.");

			// release
			Logger.printOut("Philosopher " + getName() + " releases left fork.");
			leftFork.release(this);
			Logger.printOut("Philosopher " + getName()
					+ " releases right fork.");
			rightFork.release(this);

		}
	}

}