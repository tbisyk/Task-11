package com.gmail.t.bisyk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlOperation {
	public String getTextFromUrl(String urlAddres) {
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(urlAddres);
			HttpURLConnection huc = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream()));
			String text = "";
			for (; ((text = br.readLine()) != null);) {
				sb.append(text);
				sb.append(System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public  List<String> urlToFile(String str) {
		List<String> strTemp = new ArrayList<>();
		Pattern ptr = Pattern.compile("<a\\s.*?href=\"(.+?)\".*?>(.+?)</a>");
        Matcher mtch = ptr.matcher(str);
        
        for (;mtch.find();) {
        	strTemp.add(mtch.group());
        }
        return strTemp;
	}


	public void saveUrlListToText(List<String> urlList) {
		File file = new File("url.txt");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			for (String link : urlList) {
				bw.write(link);
				bw.write(System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
