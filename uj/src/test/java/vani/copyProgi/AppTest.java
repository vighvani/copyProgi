package vani.copyProgi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
	/**
     * @Test
	 * @DisplayName("Konzolrair metodus tesztje")
     */
	 public void testKonzolraIr() throws IOException {
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
	
	
}
