package way;

import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.job51.HttpUtils;

public class Stary {

/*
 * �ⲿ��Ա��Ԯ�������Դ���
 */
	static String str="";
	
	public static void main(String[] args) throws JSONException {
	       
	        
			String adcode="����"; //440100����
			 String[] strgroup={"��ƽ���ٹ�·","��ҵ·","��ѧ·","����·","����·","������·","����·"};
			
			
			
			
             String xmlUTF8=""; 
           
		for(int i=0;i<strgroup.length;i++){
			try {
				
		
			  String str1 =strgroup[i];
			// System.out.println(str1);
			xmlUTF8 = URLEncoder.encode(str1, "UTF-8"); //����ת�� 
			 adcode=URLEncoder.encode(adcode,"UTF-8");
			String	Url ="http://restapi.amap.com/v3/traffic/status/road?name="+xmlUTF8 +"&adcode="+adcode+"&key=7d60038e76abf3d6502bbd30b394d4c6";
			
				 JSONObject jsonObj;
			
				String result=HttpUtils.doGet(Url);
				
				//System.out.println(result);
				
				JSONObject  jsonObject= null;
			    jsonObject = new JSONObject(result);
	
			  
		        System.out.print( jsonObject.getJSONObject("trafficinfo").get("description"));
		       System.out.println( jsonObject.getJSONObject("trafficinfo").getJSONObject("evaluation").get("description"));
			        
			   
			        
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				//System.out.println("û�ҵ�");
			}
		
	}	
		
	}

	
}
