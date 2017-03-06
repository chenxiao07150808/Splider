package com.Job58;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.job51.HttpUtils;

public class StartApp {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   for(int i=2;i<60;i++){//http://gz.58.com/sou/?key=%E5%BE%AE%E4%BF%A1%E5%BC%80%E5%8F%91%E5%B7%A5%E7%A8%8B%E5%B8%88&from=home-search
		String Url="http://gz.58.com/sou/pn"+i+"/?key=%E5%BE%AE%E4%BF%A1%E5%BC%80%E5%8F%91%E5%B7%A5%E7%A8%8B%E5%B8%88&from=home-search";
		gethtml(Url);
	   }
			
	}

	private static void gethtml(String url) {
		
		String result="";
		
		try {
			result=HttpUtils.doGet(url);

			Document doc=Jsoup.parse(result);
			
			Elements list=doc.select("#searchTable > tbody > tr");
			
			
			for(Element list2:list){
				//System.out.println(list);
				hander(list2);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public static void hander(Element list2){
		String title="";
		String location="";
		String pubdate="";
		Elements temp=list2.select("td a");
		if(temp!=null&&temp.size()>0){
			title=temp.get(0).attr("title");
		}
		temp=list2.select("p.abt > a:nth-child(3)");
		if(temp!=null&&temp.size()>0){
			location=temp.text();
		}
		temp=list2.select("p.abt");
		if(temp!=null&&temp.size()>0){
			pubdate=temp.get(0).ownText();
			
	}
		System.out.println(title+";"+ location+";"+ pubdate);
	}
}
