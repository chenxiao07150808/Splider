package com.fang;

import java.io.IOException;

import org.apache.commons.logging.LogFactory;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;

public class StartApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log",
				"org.apache.commons.logging.impl.NoOpLog");

		// 本质是一个浏览器
		WebClient webClient = new WebClient(BrowserVersion.CHROME);

		try {
			HtmlPage page = webClient.getPage("http://zu.gz.fang.com/house-a073/");

			for (int i = 1; i < 99; i++) {

				DomNodeList<DomNode> hyperLinks = page.querySelectorAll("#rentid_D10_01 > a");

				for (DomNode node : hyperLinks) {
					HtmlAnchor link1 = (HtmlAnchor) node;

					if (link1.asText().equals("" + i)) {
						HtmlPage page2 = link1.click();

						// System.out.println(page2.asText());
						DomNodeList<DomNode> tables = page2.querySelectorAll("#houselistbody");

						for (DomNode node2 : tables) {
							/* HtmlTable table = (HtmlTable) node2; */
							HtmlDivision table = (HtmlDivision) node2;
							// System.out.println(table.asText());
							getfriendsdatail(table);
						}
					}
				}
			}

		} catch (FailingHttpStatusCodeException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void getfriendsdatail(HtmlDivision table) {
		// TODO Auto-generated method stub
		String money="";
		String earn="";
		String localhost="";
		
		DomNodeList<DomNode> temp = table.querySelectorAll("dl > dd > div.moreInfo > p > span");
		for (DomNode list : temp) {
           if(list!=null){
        	   money=list.asText();
        	   System.out.println(money);
           }
		}
		temp = table.querySelectorAll("dl > dd > p.title > a");
		for (DomNode list : temp) {
           if(list!=null){
        	   money=list.asText();
        	   }
           
		}
	  //#rentid_D09_17_06
		temp = table.querySelectorAll("dl > dd > p#rentid_D09_17_06 > a:nth-child(1) > span");
		for (DomNode list : temp) {
           if(list!=null){
        	   localhost=list.asText();
        	  // System.out.println(localhost);
           }
           
		}
	}
	

}
