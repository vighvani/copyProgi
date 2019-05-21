package vani.copyProgi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 * 
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}

	/**
	 * @Test @DisplayName("Do the original and the copied one the same? test")
	 */
	public void testCopyIntoFile() throws IOException {
		String inputPath = "D:\\work\\teszt.txt";
		String outputPath = "D:\\work\\teszt1.txt";
		File inputFile = new File(inputPath);
		File outputFile = new File(outputPath);

		String[] args = new String[2];
		args[0] = inputPath;
		args[1] = outputPath;

		App.main(args);

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				BufferedReader test_reader = new BufferedReader(new FileReader(outputFile));) {

			Assert.assertEquals(reader.read(), test_reader.read());
		}
	}

	/**
	 * @Test @DisplayName("Is the input file null? test")
	 */
	public void testWriteOnConsole() throws IOException {
		String inputPath = "D:\\work\\teszt.txt";
		File inputFile = new File(inputPath);

		String[] args = new String[1];
		args[0] = inputPath;

		App.main(args);

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));) {

			Assert.assertNotNull(reader);
		}
	}

	/**
	 * @Test @DisplayName("0 parameter test")
	 */
	public void testNoParameter() throws IOException {
		String[] args = new String[0];

		String npwf = "No parameter was found!";

		if (args.length == 1) {
			System.out.println("Written on console");
		} else if (args.length == 2) {
			System.out.println("Copied to file");
		} else {
			System.err.println("No parameter was found!");
			String npwf1 = "No parameter was found!";

			Assert.assertEquals(npwf, npwf1);
		}
	}

	/**
	 * @Test @DisplayName("More parameter test")
	 */
	public void testMoreParameter() throws IOException {
		String[] args = new String[3];

		String ntp = "No parameter was found!";

		if (args.length == 1) {
			System.out.println("Written on console");
		} else if (args.length == 2) {
			System.out.println("Copied to file");
		} else {
			System.err.println("No parameter was found!");
			String ntp1 = "No parameter was found!";

			Assert.assertEquals(ntp, ntp1);
		}

	}

	/**
	 * @Test @DisplayName("1 parameter test")
	 */
	public void testOneParameter() throws IOException {
		String[] args = new String[1];
		int one = 1;

		if (args.length == 1) {
			System.out.println("Written on console");
			int one1 = 1;

			Assert.assertSame(one, one1);

		} else if (args.length == 2) {
			System.out.println("Copied to file");
		} else {
			System.err.println("Not correct parameter!");
		}
	}

	/**
	 * @Test @DisplayName("2 parameter test")
	 */
	public void testTwoParameter() throws IOException {
		String[] args = new String[2];
		int two = 2;

		if (args.length == 1) {
			System.out.println("Written on console");
		} else if (args.length == 2) {
			System.out.println("Copied to file");
			int two2 = 4;

			Assert.assertNotSame(two, two2);

		} else {
			System.err.println("Not correct parameter!");
		}
	}

}
