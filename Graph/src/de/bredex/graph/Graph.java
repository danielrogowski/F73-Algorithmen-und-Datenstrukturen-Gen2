package de.bredex.graph;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 
 * @author daniel
 *
 * @param <V> To ensure the proper working of this Graph, V needs to implement
 *            custom hashCode and equals methods.
 */
public class Graph<V> {
	private final Map<V, Set<V>> adjacencyMap;
	private int nrEdges = -1;

	public Graph() {
		this.adjacencyMap = new HashMap<>();
	}

	public Graph(final Map<V, Set<V>> adjacencyMap) {
		this.adjacencyMap = adjacencyMap;
	}

	public int getNrVertices() {
		return this.adjacencyMap.size();
	}

	public int getNrEdges() {
		if (this.nrEdges >= 0) {
			return this.nrEdges;
		}

		final Map<V, Set<V>> combinations = new HashMap<>();
		this.nrEdges = 0;

		for (final Map.Entry<V, Set<V>> entry : this.adjacencyMap.entrySet()) {
			final V v = entry.getKey();
			final Set<V> neighbors = entry.getValue();
			for (final V w : neighbors) {
				processCombinations(combinations, v, w, () -> this.nrEdges++);
			}
		}

		return this.nrEdges;
	}

	public void printGraph(final V startingNode, final PrintStream out) {
		Objects.requireNonNull(out);

		final Map<V, Set<V>> combinations = new HashMap<>();

		if (startingNode != null) {
			this.adjacencyMap.get(startingNode).forEach(w -> this.innerPrint(combinations, startingNode, w, out));
		}

		this.adjacencyMap.forEach((v, e) -> {
			e.forEach(w -> this.innerPrint(combinations, v, w, out));
		});
	}

	public Graph<V> addVertex(final V vertex) {
		Objects.requireNonNull(vertex);

		if (this.adjacencyMap.containsKey(vertex)) {
			return this;
		}

		this.adjacencyMap.put(vertex, new HashSet<>());

		return this;
	}

	public Graph<V> addEdge(final V v, final V w) {
		this.addVertex(v);
		this.addVertex(w);

		this.nrEdges = -1;

		this.adjacencyMap.get(v).add(w);
		this.adjacencyMap.get(w).add(v);

		return this;
	}

	public Graph<V> breadthFirstScan(final V startingNode) {
		return this.breadthFirstScan(startingNode, null);
	}

	public Graph<V> depthFirstScan(final V startingNode) {
		return this.depthFirstScan(startingNode, null);
	}

	public Graph<V> breadthFirstScan(final V startingNode, final PrintStream out) {
		return this.scan(startingNode, new GraphScanQueue<>(), out);
	}

	public Graph<V> depthFirstScan(final V startingNode, final PrintStream out) {
		return this.scan(startingNode, new GraphScanStack<>(), out);
	}

	public Graph<V> scan(V startingNode, final GraphScanStructure<V> scanStructure, final PrintStream out) {
		Objects.requireNonNull(scanStructure);

		if (this.adjacencyMap.isEmpty()) {
			return new Graph<>();
		}

		if (startingNode == null) {
			startingNode = this.adjacencyMap.keySet().iterator().next();
		}

		final Graph<V> result = new Graph<>();

		result.addVertex(startingNode);

		scanStructure.add(startingNode);

		while (!scanStructure.isEmpty()) {
			final V currentElement = scanStructure.peek();

			if (out != null) {
				out.print("\n" + currentElement + " ");
			}

			V unprocessedNeighbor = null;

			for (final V neighbor : this.adjacencyMap.get(currentElement)) {
				if (!result.adjacencyMap.containsKey(neighbor)) {
					unprocessedNeighbor = neighbor;
					break;
				}
			}
			if (unprocessedNeighbor == null) {
				scanStructure.remove();
			} else {
				result.addVertex(unprocessedNeighbor);
				result.addEdge(currentElement, unprocessedNeighbor);
				scanStructure.add(unprocessedNeighbor);

				if (out != null) {
					out.print("-> " + unprocessedNeighbor);
				}
			}
		}

		return result;
	}

	private void innerPrint(final Map<V, Set<V>> combinations, final V v, final V w, final PrintStream out) {
		processCombinations(combinations, v, w, () -> out.println(v + " <-> " + w));
	}

	private void processCombinations(final Map<V, Set<V>> combinations, final V v, final V w,
			final Runnable operation) {
		if (combinations.get(v) == null || !combinations.get(v).contains(w) && combinations.get(w) == null
				|| !combinations.get(w).contains(v)) {

			operation.run();

			if (combinations.get(v) == null) {
				combinations.put(v, new HashSet<>());
			}
			if (combinations.get(w) == null) {
				combinations.put(w, new HashSet<>());
			}

			combinations.get(v).add(w);
			combinations.get(w).add(v);
		}
	}
}
