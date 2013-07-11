package arc.test.client;

public class SFlt {
	static void cmp_swp (final int[] x, final int a, final int b) {
		if (x[a] > x[b]) {
			final int t = x[a];
			x [a] = x [b];
			x [b] = t;
		}
	}

	static void merge (final int[] x , final int lo, final int hi, final int r) {
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

	static void rng (final int[] x , final int lo, final int hi) {
		if (hi - lo >= 1) {
			final int mid = lo + (hi - lo) / 2;
			rng(x, mid+1, hi);
			rng(x, lo,   mid);
			merge(x, lo, hi, 1);
		}
	}

	static void sort (final int[] x , final int LEN) {
		rng(x, 0, LEN-1);
	}

	public static void test (final int LEN) {
		final int[] x = new int[LEN];
		for (int i = 0; i != LEN; ++i) {
			x[i] = LEN-i;
		}
		sort(x, LEN);
	}
}
