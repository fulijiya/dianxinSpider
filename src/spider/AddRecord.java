package spider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class AddRecord {
	
	private String xmlName;
	private FileOutputStream f;
	
	public AddRecord(String filename)
	{
		xmlName = filename;
	}

	public boolean createFile(){  
		boolean flag=false;
		
		try {
			//D:/ChinaNetData/是存放结果的路径，请修改
			File fileName = new File(xmlName);
			if(!fileName.exists())
			{
				fileName.createNewFile();
				flag=true;
			}else
			{
//				fileName.delete();
//				fileName.createNewFile();
				System.out.println("文件"+fileName+"已存在");
				flag = true;
			}
			f=new FileOutputStream(fileName,true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public void writeLine(String r)
	{
		try {
			f.write((r+"\r\n").getBytes());
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeFile()
	{
		try {
			f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
