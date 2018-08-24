
import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class ShakespearList {

	public static void main(String args[]){
		String fileName = "pg100.txt";
		
		try {
			Scanner scanner = new Scanner(new File(fileName));
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				//System.out.println(line);
				String[] words = line.split("\\s+");
				for(String word : words){
				word = word.replaceAll("[\\W]", "");
				word = word.toLowerCase();
				System.out.println(word);
				}
			}
			scanner.close();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		
	}
}
