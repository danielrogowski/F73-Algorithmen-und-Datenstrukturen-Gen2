package de.bredex.graph;

public interface GraphScanStructure<V> {
	void add(V element);
	V peek();
	V remove();
	boolean isEmpty();
}
