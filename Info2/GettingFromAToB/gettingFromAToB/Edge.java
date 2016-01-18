package gettingFromAToB;

public class Edge {
	// Startknoten
	public Node start;

	// Endknoten
	private Node end;

	// Gewichtung der Kante
	public int weight;

	public Edge(int weight, Node start, Node end) {
		this.weight = weight;
		this.start = start;
		this.end = end;
	}

	/*
	 * Gibt Gewichtung der Kante zur�ck
	 */
	public int getWeight() {
		return weight;
	}

	/*
	 * Legt Gewichtung der Kante fest
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/*
	 * Setzt Anfangsknoten
	 */
	public void setStart(Node start) {
		this.start = start;
	}

	/*
	 * Gibt Anfangsknoten zur�ck
	 */
	public Node getStart() {
		return start;
	}

	/*
	 * Setzt Endknoten
	 */
	public void setEnd(Node end) {
		this.end = end;
	}

	/*
	 * Gibt Endknoten zur�ck
	 */
	public Node getEnd() {

		return end;

	}

	/*
	 * Gibt Anfangsknoten, Gewichtung und Endknoten als String zur�ck
	 */
	public String toString() {
		return "from " + start + " to " + end + " it takes " + weight
				+ " hour(s).";

	}
}
