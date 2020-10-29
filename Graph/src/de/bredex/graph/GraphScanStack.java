package de.bredex.graph;

import java.util.Stack;

public class GraphScanStack<V> implements GraphScanStructure<V> {
	private Stack<V> stack = new Stack<>();

	@Override
	public void add(V element) {
		this.stack.push(element);
	}

	@Override
	public V peek() {
		return this.stack.peek();
	}

	@Override
	public V remove() {
		return this.stack.pop();
	}

	@Override
	public boolean isEmpty() {
		return this.stack.empty();
	}

}
