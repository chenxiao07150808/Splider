package com.job51;

import java.io.IOException;

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
import com.gargoylesoftware.htmlunit.html.HtmlFrame;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;

public class startApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog"); 
		 
			//本质是一个浏览器
			WebClient webClient=new WebClient(BrowserVersion.CHROME);
			
			//很多属性可以配置
			/*
			//不做页面样式渲染
			webClient.getOptions().setCssEnabled(false);
			
			//允许执行脚本
			webClient.getOptions().setJavaScriptEnabled(true);
			
			//允许浏览器 	
			webClient.getCookieManager().setCookiesEnabled(true);
			*/
			
			try {
				HtmlPage page=webClient.getPage("http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=030600%2C030500%2C030800%2C00&district=000000&funtype=0000&industrytype=00&issuedate=9&providesalary=99&keyword=%E5%BE%AE%E4%BF%A1%E5%BC%80%E5%8F%91&keywordtype=2&curr_page=2&lang=c&stype=1&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&lonlat=0%2C0&radius=-1&ord_field=0&list_type=0&fromType=14&dibiaoid=0&confirmdate=9");
			
					// System.out.println(page.asXml());
			
				 for(int i=1;i<100;i++){
				DomNodeList<DomNode> hyperLinks= page.querySelectorAll("body > div.dw_wp > div.dw_page > div > div > div > ul > li a");
				
			         
					 for(DomNode node: hyperLinks)
					 {
						 //强制类型转换
						 HtmlAnchor link1=(HtmlAnchor) node;
					//System.out.println(link2.asText());
						if(link1.asText().equals(""+i)){
							HtmlPage page2=link1.click();
							 
					       getHtml(page2.asXml());
							//DomNodeList<DomNode> tables= page2.querySelectorAll("#resultList > div> p > span > a");
							/*DomNodeList<DomNode> tables= page2.querySelectorAll("#resultList > div");
							System.out.println(tables);
							for(DomNode node2 : tables){
								HtmlFrame table = (HtmlFrame) node2;
								 */
									//System.out.println(table);	}
							
						
						
						 page=page2;
						 break;
						}else{
							getHtml(page.asText());
						}
						
							}
							
				 }
		
					
					
			
			} catch (FailingHttpStatusCodeException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void getHtml(String url){
		String result="";
		try {
			Document doc= Jsoup.parse(url);
			
			Elements list=doc.select("#resultList > div");
			
			for(Element list2:list){
				/*System.out.println(list2);
				System.out.println("====================");*/
		getJobdateil(list2);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private static void getJobdateil(Element list2) {
		// TODO Auto-generated method stub
		String jobName="";
		String salary="";
		String num="";
		String location="";
		
		Elements temp=list2.select("span > a");
		if(temp!=null&&temp.size()>0){
			jobName=temp.attr("title");
		}
		temp=list2.select("span.t2 > a");
		if(temp!=null&&temp.size()>0){
           num  =temp.attr("title");
		}
		temp=list2.select(" span.t4");
		if(temp!=null&&temp.size()>0){
			salary=temp.text();
		}
		temp=list2.select("span.t3");
		if(temp!=null&&temp.size()>0){
			location=temp.text();
		}
		if(jobName.equals("")||location.equals("")||location.equals("工作地点")){
			
		}else{
		System.out.println(jobName+";"+num+"; "+location+"; "+salary);
		}
	}

}
