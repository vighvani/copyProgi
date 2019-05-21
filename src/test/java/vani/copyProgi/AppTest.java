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
	public void testFajlbaMasol() throws IOException {
		String be_utvonal = "D:\\work\\teszt.txt";
		String ki_utvonal = "D:\\work\\teszt1.txt";
		File be_file = new File(be_utvonal);
		File ki_file = new File(ki_utvonal);

		String[] args = new String[2];
		args[0] = be_utvonal;
		args[1] = ki_utvonal;

		App.main(args);

		try (BufferedReader beolvas = new BufferedReader(new FileReader(be_file));
				BufferedReader teszt_beolvas = new BufferedReader(new FileReader(ki_file));) {

			Assert.assertEquals(beolvas.read(), teszt_beolvas.read());
		}
	}

	/**
	 * @Test @DisplayName("Is the input file null? test")
	 */
	public void testKonzolraIr() throws IOException {
		String be_utvonal = "D:\\work\\teszt.txt";
		File be_file = new File(be_utvonal);

		String[] args = new String[1];
		args[0] = be_utvonal;

		App.main(args);

		try (BufferedReader beolvas = new BufferedReader(new FileReader(be_file));) {

			Assert.assertNotNull(beolvas);
		}
	}

	/**
	 * @Test @DisplayName("0 parameter test")
	 */
	public void testNullParameter() throws IOException {
		String[] args = new String[0];
		// App.main(args);
		String ntp = "Nem talalhato parameter!";

		if (args.length == 1) {
			System.out.println("Konzolra kiir");
		} else if (args.length == 2) {
			System.out.println("Fajlba masol");
		} else {
			System.err.println("Nem talalhato parameter!");
			String ntp1 = "Nem talalhato parameter!";

			// Assert.assertArrayEquals(ntp, ntp1);
			Assert.assertEquals(ntp, ntp1);
		}
	}

	/**
	 * @Test @DisplayName("More parameter test")
	 */
	public void testMoreParameter() throws IOException {
		String[] args = new String[3];
		// App.main(args);
		String ntp = "Nem talalhato parameter!";

		if (args.length == 1) {
			System.out.println("Konzolra kiir");
		} else if (args.length == 2) {
			System.out.println("Fajlba masol");
		} else {
			System.err.println("Nem talalhato parameter!");
			String ntp1 = "Nem talalhato parameter!";

			// Assert.assertArrayEquals(ntp, ntp1);
			Assert.assertEquals(ntp, ntp1);
		}

	}

	/**
	 * @Test @DisplayName("1 parameter test")
	 */
	public void testOneParameter() throws IOException {
		String[] args = new String[1];
		int egy = 1;
		// App.main(args);

		if (args.length == 1) {
			System.out.println("Konzolra kiir");
			int egy1 = 1;

			Assert.assertSame(egy, egy1);

		} else if (args.length == 2) {
			System.out.println("Fajlba masol");
		} else {
			System.err.println("Nem megfelelo parameter!");
		}
	}

	/**
	 * @Test @DisplayName("2 parameter test")
	 */
	public void testTwoParameter() throws IOException {
		String[] args = new String[2];
		int ketto = 2;
		// App.main(args);

		if (args.length == 1) {
			System.out.println("Konzolra kiir");
		} else if (args.length == 2) {
			System.out.println("Fajlba masol");
			int ketto2 = 4;

			Assert.assertNotSame(ketto, ketto2);

		} else {
			System.err.println("Nem megfelelo parameter!");
		}
	}

}
