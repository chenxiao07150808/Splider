package way;

import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.job51.HttpUtils;

public class Stary2 {

/*
 * 外部队员的援助，非自创。
 */
	static String str="";
	
	public static void main(String[] args) throws JSONException {
	       String Url="";
	       //通过数组进行遍历。
	        String tt[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","W","X","Y","Z"};
			for(int a=0;a<tt.length;a++){
				
				String num=tt[a];
				//通过遍历逐个遍历调用。
	            getAllClub(num);
			} 
	        
			String adcode="440600"; //440100广州
			 String[] strgroup=null;
			 //获取的字符串分隔，作为高德地图的参数
			 strgroup =str.split(","); 
			
			
			
             String xmlUTF8=""; 
           
		for(int i=0;i<strgroup.length;i++){
			try {
				
		
			  String str1 =strgroup[i];
			// System.out.println(str1);
			xmlUTF8 = URLEncoder.encode(str1, "UTF-8"); //中文转码 
			 //adcode=URLEncoder.encode(adcode,"UTF-8");
				Url ="http://restapi.amap.com/v3/traffic/status/road?name="+xmlUTF8 +"&adcode="+adcode+"&key=7d60038e76abf3d6502bbd30b394d4c6";
			
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
				//System.out.println("没找到");
			}
		
	}	
		
	}

	//获取全部要找的地点
	public static boolean getAllClub(String num){
		
		try {
					
					String Html = HttpUtils.doGet("http://fs.city8.com/road/"+num+"/");
		            
					Document doc=Jsoup.parse(Html);
					
					Elements divs=doc.select("div.main_left ");
					
					for(Element div:divs){
					       
						Elements subDivs=div.select("div.road_sahngjia a ");
						//System.out.print(subDivs);
						
						if(subDivs.size()>0){
							for(int i=0;i<subDivs.size();i++)
							str+=subDivs.get(i).text()+',';
						//把地点
						}
						
					
					}	
				

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
			
		      return true;
			
		}
}
