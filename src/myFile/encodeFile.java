package myFile;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class encodeFile {
	public static void main(String[] args) {
		File encodingfile = new File("d:/LOLfolder/lol.txt");
		File encodedfile = new File("d:/LOLfolder/lol2.txt");
		encodefile(encodingfile,encodedfile);
	}
	public static void encodefile(File encodingfile,File encodedfile)
	{
		char []a = new char[(int)encodingfile.length()];
		
		try(FileReader fr = new FileReader(encodingfile))
		{
			
			fr.read(a);
			for(char each : a)
				System.out.print(each);
			System.out.println();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		int i = 0;
		try(FileWriter fw = new FileWriter(encodedfile))
		{
			for (char each : a ){
				if(each >='0'&& each <'9')
					a[i] = (char) (each+1);
				else if(each == '9')
					a[i] = '0';
				else if(each >='a'&& each < 'z')
					a[i] = (char) (each+1);
				else if(each =='z')
					a[i] = 'a';
				else if(each >='A'&& each < 'Z')
					a[i] = (char) (each+1);
				else if(each =='Z')
					a[i] = 'A';
				i++;
			}
			for(char each : a)
				System.out.print(each);
			System.out.println();
			fw.write(a);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
