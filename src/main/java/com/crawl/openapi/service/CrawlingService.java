package com.crawl.openapi.service;

import com.crawl.openapi.web.dto.CrawlingRequestDto;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

@Service
public class CrawlingService {

    private static String RfW1_URL = "http://www.wamis.go.kr:8080/wamis/openapi/wkw/rf_dubrfobs";

    @PostConstruct
    public void getRfW1Data() throws Exception {
        Document doc = Jsoup.connect(RfW1_URL).ignoreContentType(true).get();
        Elements contents = doc.select("body");

        Crawler(toString(doc));

        // System.out.println(track.size());
    }

    public static String toString(Document doc) {
        try {
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            return sw.toString();
        } catch (Exception ex) {
            throw new RuntimeException("Error converting to String", ex);
        }
    }

    public void Crawler(String str) throws Exception {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(str);
        JSONArray lists = (JSONArray) jsonObject.get("list");
        for(int i=0; i<lists.size(); i++){
            JSONObject listbody= (JSONObject) lists.get(i);

            JSONArray bbsnm = (JSONArray) listbody.get("bbsnm");
            JSONArray obscd = (JSONArray) listbody.get("obscd");
            JSONArray obsnm = (JSONArray) listbody.get("obsnm");
            JSONArray clsyn = (JSONArray) listbody.get("clsyn");
            JSONArray obsknd = (JSONArray) listbody.get("obsknd");
            JSONArray sbsncd = (JSONArray) listbody.get("sbsncd");
            JSONArray mngorg = (JSONArray) listbody.get("mngorg");

            // CrawlingRequestDto dto = new CrawlingRequestDto(bbsnm.toString(), obscd.toString(), obsnm.toString(), clsyn.toString(), obsknd.toString(), sbsncd.toString(), mngorg.toString());
            System.out.println(bbsnm);
            System.out.println(obscd);
            System.out.println(obsnm);
        }
    }


}
