package com.crawl.openapi.service;

import com.crawl.openapi.web.dto.CrawlingRequestDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.w3c.dom.Node;

import javax.annotation.PostConstruct;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class CrawlingService {

    //private static String RfW1_URL = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/rf_dubrfobs";

    @PostConstruct
    public String getRfW1Data() throws Exception {
        StringBuilder result = new StringBuilder();
        StringBuffer reult = new StringBuffer();
        String urlStr = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/rf_dubrfobs";

        URL url = new URL(urlStr);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));

        String returnLine;

        while((returnLine = br.readLine()) != null){
            result.append(returnLine+"\n\r");
        }
        urlConnection.disconnect();
        System.out.println(result.toString());
        Crawler(result.toString());

        return result.toString();

        //Document doc = Jsoup.connect(RfW1_URL).ignoreContentType(true).get();
        //Elements contents = doc.select("body");
        // Crawler(doc);
        // System.out.println(track.size());
    }

    public void Crawler(String str) throws Exception {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
        JSONArray lists = (JSONArray) jsonObject.get("list");
        for(int i=0; i<lists.size(); i++){
            JSONObject listbody= (JSONObject) lists.get(i);

            String bbsnnm = (String) listbody.get("bbsnnm");
            String obscd = (String) listbody.get("obscd");
            String obsnm = (String) listbody.get("obsnm");
            String clsyn = (String) listbody.get("clsyn");
            String obsknd = (String) listbody.get("obsknd");
            String sbsncd = (String) listbody.get("sbsncd");
            String mngorg = (String) listbody.get("mngorg");

            //todo
            // 엑셀 다운로드 만들기
            //CrawlingRequestDto dto = new CrawlingRequestDto(bbsnnm, obscd, obsnm, clsyn, obsknd, sbsncd, mngorg);
        }
    }


}
