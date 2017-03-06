package way;



import java.net.URLDecoder;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.job51.HttpUtils;


 //路况
public class Start3 {

static String str="";
	
	public static void main(String[] args) throws JSONException {
	       String Url="";
	        String tt[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","W","X","Y","Z"};
			for(int a=0;a<tt.length;a++){
				String ii=tt[a];
				
	            getAllClub(ii);
			} 
	        
			String adcode="20000"; //佛山
			 String[] strgroup=null;
			 strgroup =str.split(","); 
			
			
			
             String xmlUTF8=""; 
           
		for(int i=0;i<strgroup.length;i++){
			try {
				
		
			  String str1 =strgroup[i];
			// System.out.println(str1);
			xmlUTF8 = URLEncoder.encode(str1, "UTF-8");  
				
				Url ="http://restapi.amap.com/v3/traffic/status/road?name="+xmlUTF8 +"&adcode="+adcode+"&key=4f1b8cebf91bfd9a757c016694a487c9";
			
			
				String result=HttpUtils.doGet(Url);
				
				//System.out.println(result);
				
				JSONObject  jsonObject= null;
			    jsonObject = new JSONObject(result);
	
			  
		        System.out.print( jsonObject.getJSONObject("trafficinfo").get("description")+":");
		        System.out.print( jsonObject.getJSONObject("trafficinfo").getJSONObject("evaluation").get("status")+":");
		        System.out.println( jsonObject.getJSONObject("trafficinfo").getJSONObject("evaluation").get("description"));
			        
			   
			        
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				//System.out.println("没找到");
			}
		
	}	
		
	}

	
	public static boolean getAllClub(String ii){
		
		try {
					
					String Html = HttpUtils.doGet("http://zj.city8.com/road/"+ii+"/");
		            
					Document doc=Jsoup.parse(Html);
					
					Elements divs=doc.select("div.main_left ");
					
					for(Element div:divs){
					       
						Elements subDivs=div.select("div.road_sahngjia a ");
						//System.out.print(subDivs);
						
						if(subDivs.size()>0){
							for(int i=0;i<subDivs.size();i++)
							str+=subDivs.get(i).text()+',';
							
						}
						
					
					}	
				

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
			
		      return true;
			
		}

		}
