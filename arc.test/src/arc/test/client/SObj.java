package arc.test.client;

public class SObj {
	static void cmp_swp (final Comparable[] x, final int a, final int b) {
		if (x[a].compareTo(x[b]) > 0) {
			final Comparable t = x[a];
			x [a] = x [b];
			x [b] = t;
		}
	}

	static void merge (final Comparable[] x , final int lo, final int hi, final int r) {
		final int step = r * 2;
		if (step < hi - lo) {
			merge(x, lo, hi, step);
			merge(x, lo+r, hi, step);
			for (int i = lo+r; i < hi-r; i += step) {
				cmp_swp(x, i, i+r);
			}
		} else {
			cmp_swp(x, lo, lo+r);
		}
	}

	static void rng (final Comparable[] x , final int lo, final int hi) {
		if (hi - lo >= 1) {
			final int mid = lo + (hi - lo) / 2;
			rng(x, mid+1, hi);
			rng(x, lo,   mid);
			merge(x, lo, hi, 1);
		}
	}

	static void sort (final Comparable[] x , final int LEN) {
		rng(x, 0, LEN-1);
	}

	public static void test (final int LEN) {
		final Comparable[] x = new Comparable[LEN];
		for (int i = 0; i != LEN; ++i) {
			x[i] = LEN-i;
		}
		sort(x, LEN);
	}
}
