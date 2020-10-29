package de.bredex.graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphScanQueue<V> implements GraphScanStructure<V> {
	
	private Queue<V> queue = new LinkedList<>();

	@Override
	public void add(V element) {
		queue.add(element);
	}

	@Override
	public V peek() {
		return queue.peek();
	}

	@Override
	public V remove() {
		return queue.poll();
	}

	@Override
	public boolean isEmpty() {
		return this.queue.isEmpty();
	}

}
