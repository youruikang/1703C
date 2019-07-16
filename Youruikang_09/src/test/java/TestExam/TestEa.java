/**
 * 
 */
package TestExam;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

import stream.StreamUtil;

public class TestEa {

	@Test
	public static void test1() throws Exception {
		Closeable closeables = null;
		StreamUtil.closeAll(closeables);
	}
	@Test
	public static void test2() throws IOException {
		InputStream src = null;
		OutputStream out = null;
		boolean isCloseInputStream = false;
		boolean isCloseOutputStream = false;
		StreamUtil.copy(src, out, isCloseInputStream, isCloseOutputStream);
	}
	@Test
	public static void test3() {
		String message = null;
		StreamUtil.readIntFromSystemIn(message);
	}
	@Test
	public static void test4() {
		String message = null;
		StreamUtil.readStringFromSystemIn(message);
	}
	@Test
	public static void test5() throws IOException {
		InputStream txtFile = null;
		StreamUtil.readTextFile(txtFile);
	}
	@Test
	public static void test6() throws IOException {
		InputStream src = null;
		StreamUtil.readTextFile(src);
	}
}
