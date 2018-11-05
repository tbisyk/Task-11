package com.gmail.t.bisyk;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		UrlOperation uo = new UrlOperation();
		List<String> urlList = new ArrayList<>();
		String urlAddres = "https://google.com";
		String text = uo.getTextFromUrl(urlAddres);
		urlList = uo.urlToFile(text);
		
//		for (; text.indexOf("<a") >= 0;) {
//			urlList.add(text.substring(text.indexOf("<a"), (text.indexOf("</a>") + 4)));
//			text = text.substring(text.indexOf("</a>") + 4);
//		}
	
		urlList.forEach(a -> System.out.println(a));
		uo.saveUrlListToText(urlList);
	}
	

}
