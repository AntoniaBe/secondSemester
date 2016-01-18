package src;
public class Main {

	public static void main(String[] args) {

	normalPhilosophersDinner();
//		 produceDeadlock();
	}

	public static void normalPhilosophersDinner() {
		Philosopher p1 = new Philosopher("1");
		Fork f1 = new Fork();
		Philosopher p2 = new Philosopher("2");
		Fork f2 = new Fork();
		Philosopher p3 = new Philosopher("3");
		Fork f3 = new Fork();
		Philosopher p4 = new Philosopher("4");
		Fork f4 = new Fork();
		Philosopher p5 = new Philosopher("5");
		Fork f5 = new Fork();

		p1.setLeftFork(f5);
		p1.setRightFork(f1);

		p2.setLeftFork(f1);
		p2.setRightFork(f2);

		p3.setLeftFork(f2);
		p3.setRightFork(f3);

		p4.setLeftFork(f3);
		p4.setRightFork(f4);

		p5.setLeftFork(f4);
		p5.setRightFork(f5);

		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
	}

	public static void produceDeadlock() {
		PhilosopherDeadlock a = new PhilosopherDeadlock("A");
		Fork f1 = new Fork();
		PhilosopherDeadlock b = new PhilosopherDeadlock("B");
		Fork f2 = new Fork();
		PhilosopherDeadlock c = new PhilosopherDeadlock("C");
		Fork f3 = new Fork();
		PhilosopherDeadlock d = new PhilosopherDeadlock("D");
		Fork f4 = new Fork();
		PhilosopherDeadlock e = new PhilosopherDeadlock("E");
		Fork f5 = new Fork();

		a.setLeftFork(f5);
		a.setRightFork(f1);
		b.setLeftFork(f1);
		b.setRightFork(f2);
		c.setLeftFork(f2);
		c.setRightFork(f3);
		d.setLeftFork(f3);
		d.setRightFork(f4);
		e.setLeftFork(f4);
		e.setRightFork(f5);

		a.start();
		b.start();
		c.start();
		d.start();
		e.start();

		f1.take(a);
		f2.take(b);
		f3.take(c);
		f4.take(d);
		f5.take(e);
	}

}
