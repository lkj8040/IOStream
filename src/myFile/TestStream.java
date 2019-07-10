package myFile;
import java.io.File;//文件对象,本身不提供读写方法
import java.io.IOException;//输入输出异常对象
import java.io.FileInputStream;//输入流对象
import java.io.FileOutputStream;//输出流对象
public class TestStream {
	public static void main(String[] args) {
		
		try{
			File myfile = new File("d:/LOLfolder/eclipse.exe");
			byte []a = new byte[(int)myfile.length()];
			FileInputStream fis = new FileInputStream(myfile);
			fis.read(a);
			fis.close();
			int k =4;
			String cs[] = new String[k];
			File f[] = new File[k];
			FileOutputStream fos;
			System.out.println(a.length);
			int start = 0;
			int end = -1;
			for(int i = 0; i < k; i++){
				cs[i] = "d:/LOLfolder/eclipse.exe-" + i;
				System.out.println(cs[i]);
				f[i] = new File(cs[i]);
				fos = new FileOutputStream(f[i]);
				if(i != k-1){
					start = end + 1;
					end = start + a.length/k;
					byte[]b = new byte[end-start];
					System.arraycopy(a, start, b, 0, end-start);
					fos.write(b);
				}
				else{
					start = end + 1;
					end = a.length-1;
					
					byte[]b = new byte[end-start];
					System.arraycopy(a, start, b, 0, end-start);
					fos.write(b);
				}
				fos.close();
			}
				
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
}
