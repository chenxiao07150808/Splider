package com.weather;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class StartApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<12;i++){
			if(i<10){
			String Url="http://lishi.tianqi.com/zhongshan/20150"+i+".html";
		    getHtml(Url);
			}else{
				String Url="http://lishi.tianqi.com/zhongshan/2015"+i+".html";
				 getHtml(Url);
			}
		}
		for(int i=1;i<12;i++){
			if(i<10){
			String Url="http://lishi.tianqi.com/zhongshan/20160"+i+".html";
		    getHtml(Url);
			}else{
				String Url="http://lishi.tianqi.com/zhongshan/2016"+i+".html";
				 getHtml(Url);
			}
		}

		
	
			
	}
	public static void getHtml(String url){
		
		String result="";
		
		try {
			result=HttpUtils.doGet(url);
			
			Document doc =Jsoup.parse(result);
			
			Elements list = doc.select("#tool_site > div.tqtongji2 > ul");

			for (Element listshow : list) {
				//System.out.println(listshow);
				getMessage(listshow);
				//System.out.println("=================");
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	private static void getMessage(Element listshow) {
		// TODO Auto-generated method stub
		String maxwendu="";
		String minwendu="";
		String time="";
		String weather="";
		String windy="";
		String windyN="";
		
		Elements temp=listshow.select(" li:nth-child(1) > a");
		 if(temp!=null&&temp.size()>0){
			 time=temp.text();
		 }
		 temp=listshow.select("> li:nth-child(2)");
		 if(temp!=null&&temp.size()>0){
			 maxwendu=temp.text();
		 }
		 temp=listshow.select("li:nth-child(3)");
		 if(temp!=null&&temp.size()>0){
			 minwendu=temp.text();
		 }
		 temp=listshow.select(" li:nth-child(4)");
		 if(temp!=null&&temp.size()>0){
			 weather=temp.text();
		 }
		 temp=listshow.select(" li:nth-child(5)");
		 if(temp!=null&&temp.size()>0){
			 windy=temp.text();
		 }
		 temp=listshow.select("div.tqtongji2 > ul > li:nth-child(6)");
		 if(temp!=null&&temp.size()>0){
			 windyN=temp.text();
		 }
		 System.out.println(time+";"+maxwendu+";"+minwendu+";"+weather+";"+windy+";"+windyN);
	}

}
