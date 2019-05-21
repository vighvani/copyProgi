package vani.copyProgi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {

	public static void writeOnConsole(String[] args) {
		String inputPath = args[0];
		String line = null;
		File inputFile = new File(inputPath);

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));) {
			while ((line = reader.readLine()) != null) {
				System.out.println(line);

			}
		} catch (FileNotFoundException e) {
			System.out.println("Wrong input path!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void CopyIntoFile(String[] args) {
		String inputPath = args[0];
		String outputPath = args[1];
		String line = null;
		File inputFile = new File(inputPath);
		File outputFile = new File(outputPath);

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, false));) {
			while ((line = reader.readLine()) != null) {
				if (args.length > 1) {
					writer.write(line);
					writer.newLine();
				} else {
					System.out.println(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if (args.length == 1) {
			writeOnConsole(args);
		} else if (args.length == 2) {
			CopyIntoFile(args);
		} else {
			System.err.println("No parameter was found!");
		}
	}
}
