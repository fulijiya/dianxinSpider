package spider;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;


public class Get189 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		String url = "http://js.189.cn/WebSearch/search_search.action";
//		String [][]querys = {{"4G分享计划","乐享4G套餐","乐享3G套餐","飞young套餐","积木套餐","套餐"},								
//						{"闲时流量包","一卡双号","主副卡业务","24小时流量包","流量加餐包","翼支付","产品"}};
//		String []level0s = {"套餐","产品"};
		String [][]querys = {
				{"网龄提速","网厅免费移机","流量活动","宽带提速","优惠活动"},
		};
		String []level0s = {"优惠活动"};
		for(int i=0;i<level0s.length;i++)
		{
			AddRecord ar=new AddRecord("D://ChinaNetData//未去重//下架//优惠活动.txt");
			ar.createFile();
			for(int j=0;j<querys[i].length;j++)
			{   
				String response = postRequest(url,querys[i][j],level0s[i]);
				
				JSONObject jo = JSONObject.fromObject(response);
				JSONArray jo2 = jo.getJSONArray("resultList");
				
				for(int x=0;x<jo2.size();x++)
				{   					
					String id = jo2.getJSONObject(x).getString("id");
					IdQueue.addUnvisitedid(id);
					id = (String) IdQueue.unVisitedidDeQueue();	
					if(id!=null){
					String name=jo2.getJSONObject(x).getString("title");
					name=name.replaceAll("</?[^<]+>", "");
					ar.writeLine("<entity>");
					ar.writeLine("<"+level0s[i]+">"+name+"</"+level0s[i]+">");					
					System.out.println(id);
//					ar.writeLine("<业务介绍>");
//					GetDetails_yewu.writeContent(GetDetails_yewu.postRequest(id), ar);
//					ar.writeLine("</业务介绍>");
//					ar.writeLine("<资费介绍>");
//					GetDetails_zifei.writeContent(GetDetails_zifei.postRequest(id), ar);
//					ar.writeLine("</资费介绍>");
//					ar.writeLine("<办理及变更>");
//					GetDetails_banlijibiangeng.writeContent(GetDetails_banlijibiangeng.postRequest(id), ar);
//					ar.writeLine("</办理及变更>");
					ar.writeLine("<活动介绍>");
					GetDetails_huodong.writeContent(GetDetails_huodong.postRequest(id), ar);
					ar.writeLine("</活动介绍>");
					ar.writeLine("</entity>");
					IdQueue.addVisitedid(id);
				}
			}
		}
	}
	}
	public static String postRequest(String url,String query,String level0)
	{
		 MultiThreadedHttpConnectionManager connectionManager =new MultiThreadedHttpConnectionManager();
		 HttpClient client = new HttpClient(connectionManager);
		 PostMethod postMethod = new PostMethod(url);
		 postMethod.setRequestHeader("Host", "js.189.cn");
		 postMethod.setRequestHeader("Origin", "http://js.189.cn");
		 postMethod.setRequestHeader("Accept","image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, application/x-ms-application, application/x-ms-xbap, application/vnd.ms-xpsdocument, application/xaml+xml, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");
		 postMethod.setRequestHeader("Referer", "http://js.189.cn/WebSearch/searchHomePage.action");
		 postMethod.setRequestHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");
		 postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		 postMethod.setRequestHeader("Accept-Encoding", "gzip, deflate");
		 postMethod.setRequestHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36");
		 postMethod.setRequestHeader("Connection", "Keep-Alive");
		 postMethod.setRequestHeader("Cache-Control", "no-cache");
		 postMethod.setRequestHeader("X-Requested-With", "XMLHttpRequest");
		 postMethod  
         .setRequestBody(new NameValuePair[] {  
                 new NameValuePair("params.start", "0"),  
                 new NameValuePair("params.limit", "1000"),  
                 new NameValuePair("params.query", query),  
                 new NameValuePair("regionId", "3"),  
                 new NameValuePair("region", "3201"),
                 new NameValuePair("params.iscurrent","his"),
                 new NameValuePair("params.level0", level0),  
                 });  
		 try {
			client.executeMethod(postMethod);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		 	InputStream is = null;
	        try {
				is = postMethod.getResponseBodyAsStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
				e.printStackTrace();
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
				e.printStackTrace();
			}
	        byte[] b = baos.toByteArray();
	        try {
				baos.flush();
		        baos.close();
		        gzip.close();
		        bis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        String response = null;
			try {
				response = new String(b,"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        postMethod.releaseConnection();
	        return response;
	}
}
