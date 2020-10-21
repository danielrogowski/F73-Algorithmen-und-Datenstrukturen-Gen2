package de.bredex.euklidggt;

public class Main {
	public static void main(String[] args) {
		System.out.println("GGT: " + ggt(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}
	
	private static int ggt(int a, int b) {
		while (b != 0) {
			final int rest = a % b;
			a = b;
			b = rest;
		}
		return a;
	}
}
