package com.house58;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fang.HttpUtils;

public class StartApp2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<100;i++){
			//http://newhouse.fs.fang.com/house/s/?ctm=1.sz.xf_search.head.49
	    	 String url2="http://newhouse.fs.fang.com/house/s/b9"+i+"/?ctm=1.jm.xf_search";
	    	 getHtml(url2);
	     }

}

	private static void getHtml(String url2) {
String result="";
		
		try {
			result=HttpUtils.doGet(url2);
			
			Document doc=Jsoup.parse(result);
			
			Elements list=doc.select("#bx1 > div > div.contentListf.fl.clearfix > div.nhouse_list_content > div > div > ul > li");
			 //#loupan_2822971770 > dl
			//#bx1 > div > div.contentListf.fl.clearfix > div.nhouse_list_content > div > div > ul > li>dl
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
		Elements temp=list2.select("div.fr > h5 > span");
		if(temp!=null&& temp.size()>0){
			 money=temp.text();
			System.out.println("½­ÃÅ"+";"+money);
		}
		
		temp=list2.select("#sjina_C37_04");
		if(temp!=null&& temp.size()>0){
			str2=temp.text();
			
			
			//System.out.println(str2);
		   }
		//System.out.println("·ðÉ½"+";"+str2+";"+money);
		}
		
	}

