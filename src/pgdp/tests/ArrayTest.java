package pgdp.tests;

import static org.junit.jupiter.api.Assertions.fail;
import static pgdp.PinguLib.getConsoleOutput;
import static pgdp.array.Array.print;
import static pgdp.array.Array.minAndMax;
import static pgdp.array.Array.invert;
import static pgdp.array.Array.intersect;
import static pgdp.array.Array.linearize;
import static pgdp.array.Array.bubbleSort;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import pgdp.PinguLib;
import pgdp.array.ArrayInterface;

import java.util.Arrays;
//import org.testng.annotations.Test;

public class ArrayTest {

	@Test
	void testPrintNull() {
		PinguLib.setup();
		int[] a = new int[] {};
		print(a);
		assertEquals("{}", getConsoleOutput());

		int[] b = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
		print(b);
		assertEquals("{2147483647, " + "-2147483648}", getConsoleOutput());
		PinguLib.reset();
	}

	@Test
	void testMinAndMax() {
		PinguLib.setup();
		int[] a = new int[] {1, 2, -1, 3, Integer.MAX_VALUE};
		minAndMax(a);
		assertEquals("Minimum = " + "-1" + ", Maximum = " + "2147483647", getConsoleOutput());
		int[] b = new int[] {};
		minAndMax(b);
		assertEquals("", getConsoleOutput());
		PinguLib.reset();
		int[] c = new int[] {Integer.MIN_VALUE};
		minAndMax(c);
		assertEquals("", getConsoleOutput());
	}

	@Test
	void testInvert() {
		PinguLib.setup();
		int[] a = new int[] {0, 1, Integer.MAX_VALUE, 2, 9, -1};
		invert(a);
		System.out.println(Arrays.toString(a));
		assertEquals("[-1, 9, 2, 2147483647, 1, 0]", getConsoleOutput());
		int[] b = new int[] {};
		invert(b);
		System.out.println(Arrays.toString(b));
		assertEquals("[]", getConsoleOutput());
		PinguLib.reset();
	}

	@Test
	void testIntersect() {
		PinguLib.setup();
		int[] a = new int[] {1, Integer.MAX_VALUE, 3, 4};
		System.out.println(Arrays.toString(intersect(a, 2)));
		assertEquals("[1, 2147483647]", getConsoleOutput());

		int[] b = new int[] {-1, Integer.MAX_VALUE, 3, 4};
		System.out.println(Arrays.toString(intersect(a, 6)));
		assertEquals("[1, 2147483647, 3, 4, 0, 0]", getConsoleOutput());

		int[] c = new int[] {-1, Integer.MAX_VALUE, 3, 4};
		System.out.println(Arrays.toString(intersect(a, -2)));
		assertEquals("[]", getConsoleOutput());
		PinguLib.reset();
	}

	@Test
	void testLinearize() {
		PinguLib.setup();
		int[][] a = new int[][] {{-2}, {3, 4}, {5, 4}};
		System.out.println(Arrays.toString(linearize(a)));
		assertEquals("[-2, 3, 4, 5, 4]", getConsoleOutput());

		int[][] b = new int[][] {{-2}, {}, {Integer.MAX_VALUE, 4}};
		System.out.println(Arrays.toString(linearize(b)));
		assertEquals("[-2, 2147483647, 4]", getConsoleOutput());

		int[][] c = new int[][] {{Integer.MIN_VALUE}};
		System.out.println(Arrays.toString(linearize(c)));
		assertEquals("[-2147483648]", getConsoleOutput());

		PinguLib.reset();
	}

	@Test
	void testBubbleSort() {
		PinguLib.setup();
		int[] a = new int[] {1, Integer.MAX_VALUE, -3, 4, 1};
		bubbleSort(a);
		System.out.println(Arrays.toString(a));
		assertEquals("[-3, 1, 1, 4, 2147483647]", getConsoleOutput());
		int[] b = new int[] {};
		bubbleSort(b);
		System.out.println(Arrays.toString(b));
		assertEquals("[]", getConsoleOutput());

		int[] c = new int[] {Integer.MIN_VALUE, -4, -3, 0, -3, 2};
		bubbleSort(c);
		System.out.println(Arrays.toString(c));
		assertEquals("[-2147483648, -4, -3, -3, 0, 2]", getConsoleOutput());

		PinguLib.reset();
	}


}
