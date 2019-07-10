package myFile;
import java.io.File;
import java.util.Date;
import java.io.IOException;
import java.util.Arrays;
public class TestFile {
	public static void main(String[] args)throws IOException {
/*		File myfile = new File("d:/LoLfolder/LOL.exe");//绝对路径
		System.out.println(myfile);
		System.out.println(myfile.exists());
		System.out.println(myfile.isDirectory());//是否文件夹
		System.out.println(myfile.isFile());
		System.out.println(myfile.length());
		
		//文件最后修改的时间
		long time = myfile.lastModified();
		Date d = new Date(time);
		System.out.println(d);
		myfile.setLastModified(0);
		
		//文件重命名
		File myfile2 = new File("d:/LoLfolder/DOTA.exe");
		myfile.renameTo(myfile2);*/
		
/*		File myfile = new File("d:/LoLfolder/skin/garen.ski");
		myfile.mkdir();//创建文件夹，如果父文件夹skin不存在，就无效
		myfile.mkdirs();//创建文件夹，如果父文件夹skin不存在，则会创建父文件夹
		myfile.createNewFile();//创建一个空文件，如果父文件夹不存在，则抛出异常
		myfile.getParentFile().mkdirs();//创建父目录		
		System.out.println(Arrays.toString(myfile.list()));// 以字符串数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
		File []fs = myfile.listFiles();// 以文件数组的形式，返回当前文件夹下的所有文件（不包含子文件及子文件夹）
		System.out.println(myfile.getParent()); // 以字符串形式返回获取所在文件夹
		myfile.getParentFile();// 以文件形式返回获取所在文件夹


		myfile.listRoots();//列出所有的盘符
*//*	myfile.delete();//删除文件
		myfile.deleteOnExit();//JVM结束时，删除文件，常用于删除临时文件
*/	
		
		File myfile = new File("c:/windows");
		File[]fs = myfile.listFiles();
        if(null==fs)
            return;
        long minSize = Integer.MAX_VALUE;
        long maxSize = 0;
        File minFile = null;
        File maxFile = null;
        for (File file : fs) {
            if(file.isDirectory())
                continue;
            if(file.length()>maxSize){
                maxSize = file.length();
                maxFile = file;
            }
            if(file.length()!=0 && file.length()<minSize){
                minSize = file.length();
                minFile = file;
            }
        }
        System.out.printf("最大的文件是%s，其大小是%,d字节%n",maxFile.getAbsoluteFile(),maxFile.length());
        System.out.printf("最小的文件是%s，其大小是%,d字节%n",minFile.getAbsoluteFile(),minFile.length());
		
	
	}

}
