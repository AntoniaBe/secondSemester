package gettingFromAToB;

import java.util.ArrayList;
import java.util.Random;

public class RandomWeightedGraph extends WeightedGraph {

	private Random r;
	private ArrayList<Node> connectedNodes;

	public RandomWeightedGraph(int numberOfNodes, int numberOfEdges,
			int maximumWeight, Node enteredRoot)
			throws IllegalArgumentException {

		root = enteredRoot;
		r = new Random();
		System.out.println("Root city is: " + root.getName());

		// Wenn die Anzahl der Kanten gr��er als Anzahl aller m�glich setzbarer
		// Kanten ist,
		// dann Fehler.
		if (numberOfEdges > numberOfNodes * (numberOfNodes - 1) + 1
				|| numberOfNodes > numberOfEdges) {
			System.out
					.println("Number of Edges must be higher or equal to number of Nodes.");
		}

		int difference = numberOfEdges - numberOfNodes;

		// ArrayList verkn�pfter Knoten
		connectedNodes = new ArrayList<Node>();
		connectedNodes.add(root);

		// Entsprechend des Wertes von numberOfNodes sollen neue Knoten mit
		// Bezeichnung erstellt werden
		// Ebenso sollen neue Kanten zwischen dem Wurzelknoten und dem neuen
		// Knoten
		// mit beliebiger Gewichtung erstellt werden.
		// Durch addEdge wird dem Knoten, vom dem die Kante ausgeht, die
		// erstellte Kante hinzugef�gt
		Node startingNode = root;

		for (int i = 0; i < numberOfNodes - 1; i++) {
			Node n = new Node("City " + (i + 1), false);

			Edge e = new Edge(r.nextInt(maximumWeight), startingNode, n);

			System.out.println("New connection between: "
					+ startingNode.getName() + " and " + n.getName()
					+ "\nIt takes you " + e.getWeight()
					+ " hour(s) to get from " + startingNode.getName() + " to "
					+ n.getName() + ".");

			// Dem Startknoten die erstellte Kante zuweisen.
			startingNode.addEdge(e);

			// Erstellten Knoten zur Liste connectedNodes hinzuf�gen und neuen
			// Startknoten ausw�hlen.
			connectedNodes.add(n);
			startingNode = randomConnectedNode();
			System.out.println("Root is now: " + startingNode.getName());
		}

		// Dopplungen vermeiden
		for (int j = 0; j < difference; j++) {
			Node v1 = randomConnectedNode();
			Node v2 = randomConnectedNode();

			Edge e = new Edge(r.nextInt(maximumWeight), v1, v2);

			if (v1.equals(v2) || v1.edgeAlreadyExists(e)) {
				j--;
				// �u�ere Schleife soll weiter fortgesetzt werden
				continue;
			}

			v1.addEdge(e);
		}
	}

	/*
	 * Gibt beliebigen Knoten connectedNodes zur�ck.
	 */
	private Node randomConnectedNode() {
		int index = r.nextInt(connectedNodes.size());
		return connectedNodes.get(index);
	}

}
