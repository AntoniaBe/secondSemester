package gettingFromAToB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindingThePath {

	private Node A, B, C, D, E, F, startNode, goal;
	private ArrayList<Edge> connections;
	private ArrayList<Node> allNodes;
	private Queue<Node> visitedNodes;
	private Queue<Node> loesung;
	private boolean goalFound;

	public FindingThePath() {

		allNodes = new ArrayList<>();
		visitedNodes = new LinkedList<Node>();
		loesung = new LinkedList<Node>();

		createNodes();

		// startNode = A;
		// goal = E;
		// goalFound = false;
		//
		// connections = new ArrayList<>();
		createEdges();

	}

	public void createNodes() {

		A = new Node("City A ", false);
		B = new Node("City B ", false);
		C = new Node("City C ", false);
		D = new Node("City D ", false);
		E = new Node("City E ", false);
		F = new Node("City F ", false);

	}

	public void createEdges() {

		A.addEdge(new Edge(20, A, B));
		A.addEdge(new Edge(40, A, C));
		// A.addEdge(new Edge(20, A, E));
		B.addEdge(new Edge(14, B, C));
		B.addEdge(new Edge(14, B, F));
		C.addEdge(new Edge(19, C, D));
		// C.addEdge(new Edge(19, C, D));
		D.addEdge(new Edge(3, D, E));
		E.addEdge(new Edge(9, E, A));
		F.addEdge(new Edge(9, F, D));
		C.addEdge(new Edge(9, C, E));

		allNodes.add(A);
		allNodes.add(B);
		allNodes.add(C);
		allNodes.add(D);
		allNodes.add(E);
		allNodes.add(F);
	}

	public void findShortestPath() {

		Node n = startNode;
		System.out.println("Root is " + n.getName());

		// Solange Ziel nicht gefunden, Knoten untersuchen.

		while (goalFound == false) {

			// Knoten als besucht markieren und in Queue einfügen
			n.visited = true;
			visitedNodes.add(n);

			// Erster Knoten in Queue holen und in Liste Lösung einfügen
			Node headOfQueue = visitedNodes.peek();
			loesung.add(headOfQueue);

			// Wenn erster Knoten der Queue gleich dem Zielknoten ist, dann
			// Verbindung ausgeben und Schleife beenden
			if (headOfQueue.equals(goal)) {
				System.out.println("Goal found!\nShortest connection from "
						+ startNode.getName() + " to " + goal.getName()
						+ " over cities: ");
				for (Node c : loesung) {
					System.out.println(c.getName());
				}
				goalFound = true;
			}

			// Ansonsten ArrayList aller Kanten in connections speichern
			else {
				connections = headOfQueue.getEdges();

				// Für jede Kante in connections soll der Endknoten, also der
				// Nachbar vom
				// ersten Knoten aus der Queue untersucht werden
				for (Edge connection : connections) {
					Node e = connection.getEnd();

					// Wurde der Knoten noch nicht besucht, soll der Knoten in
					// die Queue
					// gepackt und als besucht markiert werden
					if (e.visited == false) {
						visitedNodes.add(e);
						e.visited = true;
					}

					// Wurde der Knoten schon einmal als besucht markiert, soll
					// er aus
					// der Lösungsliste entfernt werden
					else {
						loesung.remove(headOfQueue);
					}
				}

				// Hat der erste Knoten der Queue keine Nachbarn, soll er aus
				// der
				// Lösungsliste entfernt werden
				if (connections.isEmpty()) {
					loesung.remove(headOfQueue);
				}
			}

			// Wurde alles untersucht, wird der erste Knoten aus der Queue
			// entfernt
			visitedNodes.remove(headOfQueue);

		}
	}

	// #######################################################################################
	// Für Dijkstra

	public void computePaths(Node start) {

		// Weg zum Startknoten 0, denn zu sich selbst hat Startknoten keine
		// Entfernung
		start.minDistance = 0.;
		PriorityQueue<Node> vertexQueue = new PriorityQueue<Node>();

		// Startknoten wird in Warteschlange eingefügt
		vertexQueue.add(start);

		// solange Warteschlange nicht leer ist, wird der Kopf der Warteschlange
		// zurückgegeben und anschließend entfernt
		while (!vertexQueue.isEmpty()) {
			Node u = vertexQueue.poll();

			// Nachbarknoten des entnommenen Knotens mit jeweilligen Kanten
			// und deren Gewichtung werden betrachtet
			for (Edge e : u.adjacencyEdges) {

				Node v = e.start;
				double weight = e.getWeight();
				double distanceTroughU = u.minDistance + weight;

				// Prüfung ob Kosten der neuen Kante geringer als bisherige
				// Kosten
				// Wenn ja werden Kosten für diesen Knoten auf neuen Wert
				// verringert
				if (distanceTroughU < v.minDistance) {
					vertexQueue.remove(v);
					v.minDistance = distanceTroughU;
					v.previous = u;
					vertexQueue.add(v);
				}

			}

		}
	}

	public List<Node> getCheapestPathTo(Node start) {

		List<Node> path = new ArrayList<Node>();
		for (Node node = start; node != null; node = node.previous)
			path.add(node);
		return path;

	}

	public void getCheapestPath() {

		computePaths(A);
		for (Node n : allNodes) {
			System.out.println("Distance to " + n + ": " + n.minDistance);
			List<Node> path = getCheapestPathTo(n);
			System.out.println("Cheapeast Path: " + path);

		}

	}

}
