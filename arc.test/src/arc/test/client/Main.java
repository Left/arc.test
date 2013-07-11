package arc.test.client;

public class Main {

	static int LEN = 1024*1024*4;

	public static void main(final String[] args) {
		{
			final long i1 = System.currentTimeMillis(); SInt.test(LEN);
			final long i2 = System.currentTimeMillis(); System.out.println("Time = " + (double)(i2 - i1)/1000);
		}
		{
			final long i1 = System.currentTimeMillis(); SFlt.test(LEN);
			final long i2 = System.currentTimeMillis(); System.out.println("Time = " + (double)(i2 - i1)/1000);
		}
		{
			final long i1 = System.currentTimeMillis(); SObj.test(LEN);
			final long i2 = System.currentTimeMillis(); System.out.println("Time = " + (double)(i2 - i1)/1000);
		}
	}
}
