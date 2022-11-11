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
import org.testng.Assert;
import pgdp.PinguLib;
//import org.testng.annotations.Test;

public class ArrayTest {

	@Test
	void testPrintNull() {
		PinguLib.setup();
		int[] a = new int[] {};
		print(a);
		Assert.assertEquals("{}", getConsoleOutput());

		int[] b = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
		print(b);
		Assert.assertEquals("{2147483647, " + "-2147483648}", getConsoleOutput());
		PinguLib.reset();
	}

}
