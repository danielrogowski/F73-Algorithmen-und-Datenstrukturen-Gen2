package de.bredex.maxofthree;

public class Main {
	public static void main(String[] args) {
		try {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int c = Integer.parseInt(args[2]);
			System.out.println("Maximum of " + a + ", " + b + ", " + c + ": " + maxOfThree(a, b, c));
		} catch (final Exception e) {
			System.out.println("usage: 'java de.bredex.maxofthree.Main Zahl1 Zahl2 Zahl3'");
		}
	}

	private static int maxOfThree(int a, int b, int c) {
		if (a > b) {
			if (a > c) {
				return a;
			} else {
				return c;
			}
		} else if (b > c) {
			return b;
		} else {
			return c;
		}
	}
}
