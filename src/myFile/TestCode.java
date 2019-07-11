package myFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.omg.Messaging.SyncScopeHelper;
public class TestCode {
    public static void main(String[] args)throws UnsupportedEncodingException,FileNotFoundException {
//        String str = "中";
//        showCode(str);
        
    	File myfile = new File("d:/LOLfolder/mytext.txt");
    	
    	try(InputStreamReader fis = new InputStreamReader(new FileInputStream(myfile),Charset.forName("UTF-8"))){
    		char [] b = new char[(int)myfile.length()];
	    	fis.read(b);
	    	System.out.println(new String(b));
	    	for(char each:b){
	    		int i = each & 0x000000ff;
	    		System.out.print(Integer.toHexString(i)+" ");
	    	}
	    	System.out.println();
	    	fis.close();
	    }
    	catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    	String a = "我爱中国！";
    	
    	try(OutputStreamWriter fos = new OutputStreamWriter(new FileOutputStream(myfile),Charset.forName("UTF-8")))
    	{
    		fos.write(a);
    		fos.close();
    		
    	}catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    	
    	char [] b = new char[(int)myfile.length()];
    	char [] b1 = new char[(int)myfile.length()-3];
    	try(InputStreamReader fis = new InputStreamReader(new FileInputStream(myfile),Charset.forName("UTF-8"))){

	    	fis.read(b);
	    	fis.close();
	    }
    	catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	System.out.println(b);
    	System.arraycopy(b, 3, b1, 0, b1.length);

    	try(OutputStreamWriter fos = new OutputStreamWriter(new FileOutputStream(myfile),Charset.forName("UTF-8")))
    	{
    		fos.write(b1);
    		fos.close();
    		
    	}catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    	
    }

	private static void showCode(String str) {
        String[] encodes = { "BIG5", "GBK", "GB2312", "UTF-8", "UTF-16", "UTF-32" };
        for (String encode : encodes) {
            showCode(str, encode);
        }
 
    }
 
    private static void showCode(String str, String encode) {
        try {
            System.out.printf("字符: \"%s\" 的在编码方式%s下的十六进制值是%n", str, encode);
            byte[] bs = str.getBytes(encode);
 
            for (byte b : bs) {
                int i = b&0xff;//补0扩展
                System.out.print(Integer.toHexString(i) + "\t");
            }
            System.out.println();
            System.out.println();
        } catch (UnsupportedEncodingException e) {
            System.out.printf("UnsupportedEncodingException: %s编码方式无法解析字符%s\n", encode, str);
        }
    }
}
