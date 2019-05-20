package vani.copyProgi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
	
	/*A program olvassa be a fájl első paraméterét, 
	 * mint szövegfájl, majd írja vissza a konzolra.
	 * Ha mindkét paraméter meg van adva, akkor a 
	 * másodikba írja ki a beolvasott fájl tartalmát.*/
	
	public static void konzolraIr(String[] args){
		String be_utvonal = args[0];
		String sor = null;
		File be_file = new File(be_utvonal);
		
		try (BufferedReader beolvas = new BufferedReader(new FileReader(be_file));) {
			while ((sor = beolvas.readLine()) != null) {
			 System.out.println(sor);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Rossz bemeneti útvonal!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	
	
	public static void fajlbaMasol(String[] args) {
		String be_utvonal = args[0];
		String ki_utvonal = args[1];
		String sor = null;
		File be_file = new File(be_utvonal);
		File ki_file = new File(ki_utvonal);
		//FileReader be = null;
		//FileWriter ki = null;
		
		try (//be = new FileReader(be_file);
			 //ki = new FileWriter(ki_file);
			 BufferedReader beolvas = new BufferedReader(new FileReader(be_file));
			 BufferedWriter kiir = new BufferedWriter(new FileWriter(ki_file, false));) 
		{
				while ((sor = beolvas.readLine()) != null) {
					if (args.length > 1){
						kiir.write(sor);
						kiir.newLine();
					}else {
						System.out.println(sor);
					}
				}
		} catch (IOException e) {
            e.printStackTrace();
		} /* finally {
			if (be != null || ki != null) {
		        try {
		            be.close();
		            ki.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
        } */
	}
	
    public static void main( String[] args )
    {
        if (args.length == 1) {
        	konzolraIr(args);
		} else if(args.length == 2){
			fajlbaMasol(args);
        } else {
        	System.err.println("Nem található/nem megfelelő paraméter!");
        }
    }
}
