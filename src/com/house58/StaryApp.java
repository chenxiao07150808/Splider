package com.house58;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fang.HttpUtils;

public class StaryApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<50;i++){
	    	 //http://newhouse.gz.fang.com/house/s/b810-b95-c9y/
	    	 //http://newhouse.gz.fang.com/house/s/b810-b94-c9y/
	         //http://newhouse.sz.fang.com/house/s/b92/?ctm=1.sz.xf_search.page.2
	    	// String url="http://zu.st.fang.com/house-a0115"+a+"/i3"+i+"/";
	    	 String url2="http://newhouse.gz.fang.com/house/s/b810-b9"+i+"-c9y/";
	    	 getHtml(url2);
	     }

}

	private static void getHtml(String url2) {
		// TODO Auto-generated method stub
String result="";
		
		try {
			result=HttpUtils.doGet(url2);
			
			Document doc=Jsoup.parse(result);
			
			Elements list=doc.select("#bx1 > div > div.fw880 > div.contentList.fl.clearfix > ul");
			 //#bx1 > div > div.fw880 > div.contentList.fl.clearfix > ul
			for(Element list2:list){
				/*System.out.println(list2);
				System.out.println("===========================");*/
			
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
		String eary="";
		 String str2="";
		Elements temp=list2.select("div.fprice > div > span.pr1");
		if(temp!=null&& temp.size()>0){
			 money=temp.text();
			 
		}
		temp=list2.select("div.finfo > div.fl.guanjianzi.hidden.mt20 > a:nth-child(1)" );
		if(temp!=null&& temp.size()>0){
			
			name=temp.text();
		   
		}
		temp=list2.select("div.finfo > p > span");
		if(temp!=null&& temp.size()>0){
			String str=temp.text();
		    eary=str.substring(0,8);
		  str2=str.substring(14,19);
		}
		
		//System.out.println(money+";"+name+";"+eary+";"+str2);
		System.out.println(name+";"+eary+";"+str2+";"+money);
		
	}

	
	}
