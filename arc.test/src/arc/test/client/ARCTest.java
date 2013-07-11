/**
 * 
 */
package arc.test.client;

import com.google.gwt.core.client.EntryPoint;

/**
 * @author Left
 *
 */
public class ARCTest implements EntryPoint {
	public static native void dw(String s) /*-{
	  return document.write(s);
	}-*/;

	static int LEN = 1024*1024*4;

	@Override
	public void onModuleLoad() {
		{
			final long i1 = System.currentTimeMillis(); SInt.test(LEN);
			final long i2 = System.currentTimeMillis(); dw("Time = " + (double)(i2 - i1)/1000 + "</br>");
		}
		{
			final long i1 = System.currentTimeMillis(); SFlt.test(LEN);
			final long i2 = System.currentTimeMillis(); dw("Time = " + (double)(i2 - i1)/1000 + "</br>");
		}
		{
			final long i1 = System.currentTimeMillis(); SObj.test(LEN);
			final long i2 = System.currentTimeMillis(); dw("Time = " + (double)(i2 - i1)/1000 + "</br>");
		}
	}

}
