package src;
public class Philosopher extends Thread {

	private Fork leftFork;
	private Fork rightFork;

	public void run() {

		while (true) {
			// not hungry, waiting
			Logger.printOut("Philosopher " + getName() + " is waiting.");
			waiting();

			// hungry
			Logger.printOut("Philosopher " + getName() + " is hungry.");

			rightFork.take(this);
			Logger.printOut("Philosopher " + getName() + " grabs right fork.");

			leftFork.take(this);
			Logger.printOut("Philosopher " + getName() + " grabs left fork.");

			// eating
			Logger.printOut("Philosopher " + getName() + " has two forks and is eating.");
			eating();

			// release
			Logger.printOut("Philosopher " + getName() + " is done eating.");
			rightFork.release(this);
			Logger.printOut("Philosopher " + getName() + " releases right fork.");
			leftFork.release(this);
			Logger.printOut("Philosopher " + getName() + " releases left fork.");

		}
	}

	private void eating() {
		RandomWait.waitRandom();
	}

	private void waiting() {
		RandomWait.waitRandom();
	}

	public Philosopher(String name) {

		super(name);
	}

	public Fork getLeftFork() {
		return leftFork;
	}

	public void setLeftFork(Fork leftFork) {
		this.leftFork = leftFork;
	}

	public Fork getRightFork() {
		return rightFork;
	}

	public void setRightFork(Fork rightFork) {
		this.rightFork = rightFork;
	}

}
