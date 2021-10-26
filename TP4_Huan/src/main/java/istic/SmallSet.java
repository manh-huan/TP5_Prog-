package istic;

import java.util.Arrays;

public class SmallSet {

	private boolean[] tab = new boolean[256];

	public SmallSet() {
		for (int i = 0; i <= 255; i++) {
			tab[i] = false;
		}
	}

	public SmallSet(boolean[] t) {
		for (int i = 0; i <= 255; i++) {
			tab[i] = t[i];
		}

	}

	/** return nombre de valeurs appartenant à l'ensemble **/

	public int size() {

		int a = 0;
		for (int i = 0; i <= 255; i++) {
			if (this.contains(i)) {
				a++;
			}
		}
		return a;
	}

	public boolean contains(int x) {
		return x >= 0 && x <= 255 && this.tab[x];

	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void add(int x) {
		if (!this.contains(x) && x >= 0 && x <= 255) {
			this.tab[x] = true;

		}
	}

	public void remove(int x) {
		if (this.contains(x)) {
			this.tab[x] = false;

		}
	}

	public void addInterval(int deb, int fin) {
		if (0 <= deb && deb <= fin && fin <= 255) {
			for (int i = deb; i < fin; i++) {
				this.tab[i] = true;
			}

		}
	}

	public void removeInterval(int deb, int fin) {
		if (0 <= deb && deb <= fin && fin <= 255) {
			for (int i = deb; i < fin; i++) {
				this.tab[i] = false;
			}

		}
	}

	public void union(SmallSet set2) {
		if (this != set2) {
			for (int i = 0; i <= 255; i++) {
				this.tab[i] = this.tab[i] || set2.tab[i];
			}
		}
	}

	public void intersection(SmallSet set2) {
		if (this != set2) {
			for (int i = 0; i <= 255; i++) {
				this.tab[i] = this.tab[i] && set2.tab[i];
			}
		}
	}

	public void difference(SmallSet set2) {
		if (this != set2) {
			for (int i = 0; i <= 255; i++) {
				this.tab[i] = this.tab[i] && !set2.tab[i];
			}
		}

	}

	public void symetricDifference(SmallSet set2) {
		for (int i = 0; i <= 255; i++) {
			this.tab[i] = this.tab[i] ^  set2.tab[i];

	}
	}
	public void complement() {
		for (int i = 0; i < 256; i++) {
			this.tab[i] = !this.tab[i];
		}
	}

	public void clear() {
		for (int i = 0; i < 256; i++) {
			this.tab[i] = false;
		}
	}

	public boolean isIncludedIn(SmallSet set2) {
		boolean include = true;
		if (this == set2) {
			include = true;
		} else if (this.size() > set2.size()) {
			include = false;

		} else {
			for (int i = 0; i <= 255; i++) {
				if (this.tab[i] && !set2.tab[i]) {
					include = false;
				}

			}

		}
		return include;
	}

	public SmallSet clone() {
		return new SmallSet(this.tab);
	}

	@Override
	public boolean equals(Object set2) {
		if (this == set2) {
			return true;
		} else if (!(set2 instanceof SmallSet)) {
			return false;
		} else {
			SmallSet s2 = (SmallSet) set2;
			return Arrays.equals(this.tab, s2.tab);
		}

	}

	@Override
	public String toString() {
		String s = " élement présents:";
		for (int i = 0; i <= 255; ++i) {
			if (tab[i]) {
				s = s + i + " ";
			}
		}
		return s;
	}
}