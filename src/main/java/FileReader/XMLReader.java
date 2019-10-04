package FileReader;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class XMLReader implements Reader {
    public String[] fileReader(String fileName)throws Exception{
        ArrayList<String> requestArray1= new ArrayList<>();
        File xmlFile= new File(fileName);
        DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance();
        DocumentBuilder builder= dbFactory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile);
        NodeList nList= doc.getElementsByTagName("Command");
        for(int j=0; j<nList.getLength();j++){
            Node requestNode= nList.item(j);
            requestArray1.add(requestNode.getTextContent());
        }
        String[] requestArray= new String[requestArray1.size()];
        requestArray= requestArray1.toArray(requestArray);
        return requestArray;
    }
}
