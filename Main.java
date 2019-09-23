import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception
	{
		Reader reader;
		JSONParser jp = new JSONParser();
		char st;
		try {
			reader = new InputStreamReader(new FileInputStream(args[0]));
			reader = new BufferedReader(reader);
			st = (char) jp.parse(reader);
			System.out.println(st);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void edit(String s, String s2)
	{
		StringBuffer input = new StringBuffer();
		String temp;
		File inputFile = new File(s);
		File outputFile = new File(s2);
		try
		{
			Scanner sc = new Scanner (inputFile);
			while(sc.hasNextLine())
			{
				temp=sc.nextLine();
				char[] temp3 =temp.toCharArray();
				int len =temp3.length;
				for(int i=0; i< len; i++)
				{
				
					if (!Character.isWhitespace(temp3[i]))
					{
						input.append(Character.toLowerCase(temp3[i]));
					}
				}
				FileWriter fw = new FileWriter(outputFile, true);								
				fw.write(input + "\n");		
				input.delete(0, input.length());
				fw.close();
			}
			
			sc.close();
		}
		catch (Exception e){
			System.out.println("fail" + e.getMessage());
			System.exit(1);			
		}
		
	}
	
}