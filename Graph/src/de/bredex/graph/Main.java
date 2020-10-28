package de.bredex.graph;

public class Main {

	public static void main(String[] args) {
		graphScriptPage21();
		graphScriptPage19();
	}

	private static void graphScriptPage21() {
		System.out.println("\n--------------------");
		System.out.println("\nGraph from script page 21:\n");

		final Graph<String> graph = new Graph<>();

		// connected component of s
		final String s = "s";
		final String v1 = "v1";
		final String v2 = "v2";
		final String v4 = "v4";
		final String v6 = "v6";

		graph.addEdge(s, v1);
		graph.addEdge(s, v2);
		graph.addEdge(v1, v2);
		graph.addEdge(v1, v4);
		graph.addEdge(v1, v6);
		graph.addEdge(v2, v4);
		graph.addEdge(v4, v6);
		
		// not connected to s
		final String v3 = "v3";
		final String v5 = "v5";
		final String v7 = "v7";
		
		graph.addEdge(v3, v5);
		graph.addEdge(v3, v7);
		graph.addEdge(v5, v7);
		

		doStuff(graph, s);

		System.out.println("\n\n--------------------");
	}

	private static void graphScriptPage19() {
		System.out.println("\n--------------------");
		System.out.println("\nGraph from script page 19:\n");
		System.out.println("(The vertices are numbered like the order the are visited.)\n");

		// connecte component (Zusammenhangskomponente) of s
		final String s = "s";
		final String v1 = "v1";
		final String v2 = "v2";
		final String v3 = "v3";
		final String v4 = "v4";
		final String v5 = "v5";
		final String v6 = "v6";
		final String v7 = "v7";
		final String v8 = "v8";
		final String v9 = "v9";
		final String v10 = "v10";
		final String v11 = "v11";
		final String v12 = "v12";
		final String v13 = "v13";
		final String v14 = "v14";

		// not connected to s
		final String v15 = "v15";
		final String v16 = "v16";
		final String v17 = "v17";
		final String v18 = "v18";
		final String v19 = "v19";
		final String v20 = "v20";

		final Graph<String> graph = new Graph<>();

		// edges in the order of the algorithm
		graph.addEdge(s, v1);
		graph.addEdge(v1, v2);
		graph.addEdge(v1, v3);
		graph.addEdge(s, v4);
		graph.addEdge(v4, v5);
		graph.addEdge(v5, v6);
		graph.addEdge(v6, v7);
		graph.addEdge(v7, v8);
		graph.addEdge(v7, v9);
		graph.addEdge(v7, v10);
		graph.addEdge(v10, v11);
		graph.addEdge(v4, v12);
		graph.addEdge(v4, v13);
		graph.addEdge(v4, v14);

		// edges still missing in the connected component of s
		graph.addEdge(s, v14);
		graph.addEdge(s, v12);
		graph.addEdge(v14, v13);
		graph.addEdge(v12, v5);
		graph.addEdge(v5, v13);
		graph.addEdge(v12, v9);
		graph.addEdge(v5, v9);
		graph.addEdge(v13, v6);
		graph.addEdge(v13, v11);
		graph.addEdge(v9, v6);
		graph.addEdge(v6, v11);
		graph.addEdge(v6, v10);

		// edges belonging to the second connected component (not connected to s)
		graph.addEdge(v15, v16);
		graph.addEdge(v15, v17);
		graph.addEdge(v16, v17);
		graph.addEdge(v17, v18);
		graph.addEdge(v18, v19);
		graph.addEdge(v18, v20);
		graph.addEdge(v19, v20);

		doStuff(graph, s);

		System.out.println("\n--------------------");
	}

	private static <V> void doStuff(final Graph<V> graph, final V s) {
		System.out.println("Original Graph:");
		graph.printGraph(s, System.out);
		
		System.out.println("\nnr vertices: " + graph.getNrVertices());
		System.out.println("nr edges: " + graph.getNrEdges());

		System.out.print("\nbreadth first tree search:");
		Graph<V> breadthFirstTree = graph.breadthFirstScan(s, System.out);
		
		System.out.println("\n\nbreadth first tree result:");
		breadthFirstTree.printGraph(s, System.out);

		System.out.print("\n\ndepth first tree:");
		Graph<V> depthFirstTree = graph.depthFirstScan(s, System.out);
		
		System.out.println("\n\ndepth first tree result:");
		depthFirstTree.printGraph(s, System.out);
	}

}
