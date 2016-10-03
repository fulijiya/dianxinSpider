package spider;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class GetDetails_zifei {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a= postRequest("274192");
		System.out.println(a);
//		AddRecord ar = new AddRecord("D:/ChinaNetData/189data/linzidale.txt");
//		ar.createFile();
//		String a ="[{\"content\":\"950509多方通话\",\"level\":\"1\",\"nodeNum\":0,\"titleName\":\"产品名称\",\"actualNOdeNum\":0,\"airNodeNum\":0,\"upBeanXml\":null},{\"content\":\"950509多方通话业务是指在一次通话中可同时和多人（多部电话）通话的业务。\",\"level\":\"1\",\"nodeNum\":0,\"titleName\":\"简介\",\"actualNOdeNum\":0,\"airNodeNum\":0,\"upBeanXml\":null},{\"content\":\"1、多方通话和录音功能主要面向政企客户，有效提高政企客户业务收益。&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;2、不使用本产品则不会生成功能费。\",\"level\":\"1\",\"nodeNum\":0,\"titleName\":\"亮点\",\"actualNOdeNum\":0,\"airNodeNum\":0,\"upBeanXml\":null},{\"content\":\"2010-09-09 00:00:00,\",\"level\":\"1\",\"nodeNum\":0,\"titleName\":\"办理起止时间\",\"actualNOdeNum\":0,\"airNodeNum\":0,\"upBeanXml\":null},{\"content\":\"\",\"level\":\"1\",\"nodeNum\":1,\"titleName\":\"适用范围\",\"actualNOdeNum\":2,\"airNodeNum\":1,\"upBeanXml\":null},{\"content\":\"1、主叫客户：适用于江苏省后付费普通固话客户（注意：预付费固话、智能网电话、公用电话和天翼手机客户暂不能办理）。&nbsp;&nbsp;&nbsp; 2、被叫客户：适用于全国各运营商电话（不含台港澳和国际长途）。\",\"level\":\"2\",\"nodeNum\":0,\"titleName\":\"适用客户\",\"actualNOdeNum\":0,\"airNodeNum\":0,\"upBeanXml\":{\"content\":\"\",\"level\":\"1\",\"nodeNum\":1,\"titleName\":\"适用范围\",\"actualNOdeNum\":2,\"airNodeNum\":1,\"upBeanXml\":null}},{\"content\":\"\",\"level\":\"1\",\"nodeNum\":2,\"titleName\":\"功能介绍\",\"actualNOdeNum\":4,\"airNodeNum\":2,\"upBeanXml\":null},{\"content\":\"1、本产品支持2－61方的通话。&nbsp;&nbsp;&nbsp; 2、客户通过拨打具备多方通话功能的950509接入号码，实现通达国内所有地区（不含港澳台）的多方通话服务。&nbsp;&nbsp;&nbsp; 3、通话录音功能：客户呼入平台后，在外呼拨号前，可以选择是否开启本次通话的录音。录音将保留7天，客户可在通话挂机后，呼入平台听取相应的录音内容。\",\"level\":\"2\",\"nodeNum\":0,\"titleName\":\"产品功能\",\"actualNOdeNum\":0,\"airNodeNum\":0,\"upBeanXml\":{\"content\":\"\",\"level\":\"1\",\"nodeNum\":2,\"titleName\":\"功能介绍\",\"actualNOdeNum\":4,\"airNodeNum\":2,\"upBeanXml\":null}},{\"content\":\"\",\"level\":\"2\",\"nodeNum\":1,\"titleName\":\"服务平台\",\"actualNOdeNum\":3,\"airNodeNum\":2,\"upBeanXml\":{\"content\":\"\",\"level\":\"1\",\"nodeNum\":2,\"titleName\":\"功能介绍\",\"actualNOdeNum\":4,\"airNodeNum\":2,\"upBeanXml\":null}},{\"content\":\"接入号码950509，服务热线4008208263（工作时间：每天9：00-21：00）。\",\"level\":\"3\",\"nodeNum\":0,\"titleName\":\"服务号码\",\"actualNOdeNum\":0,\"airNodeNum\":0,\"upBeanXml\":{\"content\":\"\",\"level\":\"2\",\"nodeNum\":1,\"titleName\":\"服务平台\",\"actualNOdeNum\":3,\"airNodeNum\":2,\"upBeanXml\":{\"content\":\"\",\"level\":\"1\",\"nodeNum\":2,\"titleName\":\"功能介绍\",\"actualNOdeNum\":4,\"airNodeNum\":2,\"upBeanXml\":null}}},{\"content\":\"\",\"level\":\"-1\",\"nodeNum\":0,\"titleName\":\"950509多方通话\",\"actualNOdeNum\":0,\"airNodeNum\":0,\"upBeanXml\":null}]";
//		writeContent(a,ar);
//		ar.closeFile();
	}

	public static String postRequest(String docId)
	{
		String refererURL = "http://js.zhidao.189.cn/WebSearch/showdetail_detailIndex.action?ownerId="+docId+"&type=0&in_cmpid=zd-zsd-"+docId;
//		System.out.println(refererURL); 
		MultiThreadedHttpConnectionManager connectionManager =new MultiThreadedHttpConnectionManager();
		 HttpClient client = new HttpClient(connectionManager);
//		 client.getHostConfiguration().setProxy("10.167.196.133", 8080);
		 PostMethod postMethod = new PostMethod("http://js.zhidao.189.cn/WebSearch/showdetail_queryDetailInfo.action");
		 postMethod.setRequestHeader("Host", "js.zhidao.189.cn");
		 postMethod.setRequestHeader("Origin", "http://js.zhidao.189.cn");
		 postMethod.setRequestHeader("Accept","image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, application/x-ms-application, application/x-ms-xbap, application/vnd.ms-xpsdocument, application/xaml+xml, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");
		 postMethod.setRequestHeader("Referer", refererURL);
		 postMethod.setRequestHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
		 postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		 postMethod.setRequestHeader("Accept-Encoding", "gzip, deflate");
		 postMethod.setRequestHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36");
		 postMethod.setRequestHeader("Connection", "Keep-Alive");
		 postMethod.setRequestHeader("Cache-Control", "no-cache");
		 postMethod.setRequestHeader("X-Requested-With", "XMLHttpRequest");
		 postMethod  
         .setRequestBody(new NameValuePair[] {  
                 new NameValuePair("docId", docId),  
                 new NameValuePair("nodePath", "ZFJS"),    
                 });  
		 try {
			client.executeMethod(postMethod);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error in docId(step 2) " + docId);
			return "";
		}  
		 	InputStream is = null;
	        try {
				is = postMethod.getResponseBodyAsStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("error in docId(step 2) " + docId);
				return "";
			}
	        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
	        byte[] data = new byte[4096];  
	        int count = -1;  
	        try {
				while((count = is.read(data,0,4096)) != -1)  
				    outStream.write(data, 0, count);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	          
	        data = outStream.toByteArray();
	        ByteArrayInputStream bis = new ByteArrayInputStream(data);
	        GZIPInputStream gzip = null;
			try {
				gzip = new GZIPInputStream(bis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return null;
//				e.printStackTrace();
			}
	        byte[] buf = new byte[1024];
	        int num = -1;
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        try {
				while ((num = gzip.read(buf, 0, buf.length)) != -1) {
			 	 baos.write(buf, 0, num);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
	        byte[] b = baos.toByteArray();
	        try {
				baos.flush();
		        baos.close();
		        gzip.close();
		        bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
	        String response = null;
			try {
				response = new String(b,"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
	        postMethod.releaseConnection();
	        return response.replaceAll("</?[^<]+>", "");
	}
	
	public static void writeContent(String con,AddRecord ar)
	{
		
		JSONArray ja = JSONArray.fromObject(con);
		for(int i=0;i<ja.size()-1;i++)
		{
			JSONObject _t = ja.getJSONObject(i);
//			System.out.println(line);
			String content = _t.getString("content");
//			String level = _t.getString("level");
			String titleName = _t.getString("titleName");
			int nodeNum = _t.getInt("nodeNum");
			if(0==nodeNum)
			{
				ar.writeLine("<"+titleName+">"+content+"</"+titleName+">");
			}
			else
			{
				ar.writeLine("<"+titleName+">");
				for(int j=0;j<nodeNum;j++)
				{
					i++;
					_t = ja.getJSONObject(i);
					String nodeContent = _t.getString("content");
					String nodeTitleName = _t.getString("titleName");
					ar.writeLine("<"+nodeTitleName+">"+nodeContent+"</"+nodeTitleName+">");
				}
				ar.writeLine("</"+titleName+">");
			}
			
		}
		
	}
}
