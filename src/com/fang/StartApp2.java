package com.fang;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class StartApp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int a=59;a<66;a++){
     for(int i=1;i<50;i++){
    	 //http://newhouse.gz.fang.com/house/s/b810-b95-c9y/
    	 //http://newhouse.gz.fang.com/house/s/b810-b94-c9y/
         //http://newhouse.gz.fang.com/house/s/c9y-b810/
    	// String url="http://zu.st.fang.com/house-a0115"+a+"/i3"+i+"/";
    	 String url2="http://newhouse.gz.fang.com/house/s/b810-b9"+i+"-c9y/";
    	 getHtml(url2);
     }
		}
	}

	private static void getHtml(String url) {
		String result="";
		
		try {
			result=HttpUtils.doGet(url);
			
			Document doc=Jsoup.parse(result);
			
			Elements list=doc.select("#listBox > div.houseList >dl>dd ");
			
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
/*
 * <dd class="info rel"> 
 <p class="title" id="rentid_D09_30_02"> <a href="/chuzu/3_183307417_1.htm" target="_blank" title="!经典3室6200元!超值!免费点击!免费看房!">!经典3室6200元!超值!免费点击!免费看房!</a> </p> 
 <p class="font16 mt20 bold"> 整租<span class="splitline">|</span>3室1厅<span class="splitline">|</span>72㎡<span class="splitline">|</span>（高层）/共33层<span class="splitline">|</span>朝南北 </p> 
 <p class="gray6 mt20" id="rentid_D09_30_06">天河租房-<a href="http://zu.gz.fang.com/house-a073-b013855/" target="_blank"><span>珠江新城中</span></a>-<a href="http://zu.gz.fang.com/house-xm2811481702/" target="_blank"><span>方圆月岛</span></a> </p> 
 <div id="rentid_D09_30_07">
  <p class="mt12"><span class="note subInfor">距5号线<a href="http://zu.gz.fang.com/house1-j036-k0739/">猎德站</a>约306米，距<a href="http://zu.gz.fang.com/bus/72045/">冼村路南</a>公交站约222米</span></p>
 </div> 
 <p class="gray6 mt15" style="line-height: 16px;"> <span class="gray9 pr10">4分钟前更新</span> <span id="rentid_D09_30_05"><a id="im_164329681" onclick="Im.click('a13640883645','覃应','广州','方圆月岛','http://img1.soufunimg.com/viewimage/usercenter/2015_11/04/17/avatar/120_164329681_0/275x207.jpg','13640883645');" href="javascript:void(0);"><img title="点击在线咨询" alt="点击在线咨询" style="display: none; border:none;vertical-align:top; cursor: pointer;" name="164329681online" src="http://img.soufun.com/rent/image/rent/FangJsCss/images/talkAgentIcon.gif"><img title="点击在线咨询" alt="点击在线咨询" style="display: ; border:none;vertical-align:top;cursor: pointer;" name="164329681offline" src="http://img.soufun.com/rent/image/rent/FangJsCss/images/btnLixian.gif"></a></span> </p> 
 <p class="mt12"><span class="note colorGreen">近地铁</span><span class="note colorRed">随时入住</span><span class="note colorBlue">南北对流</span></p> 
 <div class="moreInfo"> 
  <p class="mt5 alingC"><span class="price">6200</span>元/月</p> 
 </div> 
 <!-- 0505compare start --> 
 <div style="display: none;" class="notice" id="rentid_D09_30_04">
  <a class="gray6 duibi">对比</a>
 </div> 
 <!-- 0505compare end --> 
</dd>
 */
	private static void getMessage(Element list2) {
		// TODO Auto-generated method stub
		String name="";
		String money="";
		String eary="";
		 String str2="";
		Elements temp=list2.select(" div.moreInfo > p > span");
		if(temp!=null&& temp.size()>0){
			 money=temp.text();
		}
		temp=list2.select("p> a:nth-child(1) > span" );
		if(temp!=null&& temp.size()>0){
			/*String str=temp.text();
			String[] str2=str.split("-");
			name=str2[1];*/
			name=temp.text();
			//System.out.println(name);
			//#rentid_D09_02_06 > a:nth-child(1) > span
			//#rentid_D09_03_06 > a:nth-child(2) > span   #rentid_D09_03_06 > a:nth-child(1)
		}//#rentid_D09_11_06 > a:nth-child(1)   #rentid_D09_10_06 > a:nth-child(1) > span
		temp=list2.select(" p.font16.mt20.bold");
		if(temp!=null&& temp.size()>0){
			 String str=temp.text();
			 eary=str.substring(3,7);
		     str2=str.substring(8,11);
		  //  System.out.println(str);
		    //System.out.println(str2);
		}
		
		System.out.println(name+";"+eary+";"+str2+";"+money);
	}

}
