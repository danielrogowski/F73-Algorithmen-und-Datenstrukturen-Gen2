package de.bredex.prim;

public class Main {
	public static void main(String[] args) {
		try {
			prim(Integer.parseInt(args[0]));
		} catch (final Exception e) {
			System.out.println("invoke with: 'java de.bredex.prim.Main positive_Ganzzahl'");
		}
	}

	private static void prim(int s) {
		if (s < 2) {
			throw new RuntimeException();
		}
		
		boolean[] markers = new boolean[s - 1];

		for (int prim = 2; prim <= s; prim++) {
			int i = prim - 2;
			if (!markers[i]) {
				System.out.println(prim);
				for (int vielfache = 2 * prim; vielfache <= s; vielfache += prim) {
					int j = vielfache - 2;
					markers[j] = true;
				}
			}
		}
	}
}
