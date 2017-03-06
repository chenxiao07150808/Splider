package com.price;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class StartApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		//http://www.lvguo.net/baojia/%E9%B8%A1/2500/
		 //adcode=URLEncoder.encode(adcode,"UTF-8");
		   for(int i=1;i<19572;i++){
			   if(i==1){
			  String url2="http://www.lvguo.net/baojia/";
			 getHtml(url2);
			   }else{
				   String url2="http://www.lvguo.net/baojia/t"+i;
			    	 getHtml(url2);
			   }
		   }
	    	
	  
	}

	private static void getHtml(String url2) {
		// TODO Auto-generated method stub
String result="";
		
		try {
			result=HttpUtils.doGet(url2);
			
			Document doc=Jsoup.parse(result);
			
			Elements list=doc.select("body > div:nth-child(3) > table > tbody > tr");
			 //#bx1 > div > div.fw880 > div.contentList.fl.clearfix > ul
			for(Element list2:list){
				/*System.out.println(list2);
				System.out.println("===========================");
		*/
			getMessage(list2);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void getMessage(Element list2) {
		// TODO Auto-generated method stub
		String name="";
		String money="";
		String location="";
		
		Elements temp=list2.select("td:nth-child(2) > a");
		if(temp!=null&& temp.size()>0){
			 location=temp.text();
			//System.out.println(name);
		}
		
		temp=list2.select("td:nth-child(4) > p:nth-child(1) > b");
		if(temp!=null&& temp.size()>0){
			money=temp.text();
			//System.out.println(money);
			
			//System.out.println(str2);
		   }
		temp=list2.select("td:nth-child(4) > p:nth-child(1)");
		if(temp!=null&& temp.size()>0){
			name=temp.text();
		//	System.out.println(money);
			
		
		   }
       if(name.equals("")||money.equals("")||location.equals("")){
			
		}else{
			System.out.println(name+";"+location+";"+money);
		}
		
	}
   
}
