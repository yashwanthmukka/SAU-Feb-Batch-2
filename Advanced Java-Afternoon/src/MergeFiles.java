import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class MergeFiles {

	public static void main(String[] args) {
		
		try { 
            
			 
			
            File file1 = new File("file1.xml"); 
            File file2 = new File("file2.xml"); 
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
            
            
            DocumentBuilder db = dbf.newDocumentBuilder(); 
            
            Document doc1 = (Document) db.parse(file1); 
            Document doc2 = (Document) db.parse(file2);
            
            ((org.w3c.dom.Document) doc1).getDocumentElement().normalize(); 

            ((org.w3c.dom.Document) doc2).getDocumentElement().normalize();
            
            Document merged_doc = (Document) db.newDocument();
            Element root = ((org.w3c.dom.Document) merged_doc).createElement("CSR_Producer");
    		((Node) merged_doc).appendChild(root);
    		
            System.out.println( "Root element: "+ ((org.w3c.dom.Document) doc1).getDocumentElement().getNodeName()); 
            
            Map<String,Element> mapper = new HashMap<String,Element>();
            
            NodeList nodeList1 = ((Element) doc1).getElementsByTagName("CSR_Producer");
            NodeList nodeList2 = ((Element) doc2).getElementsByTagName("CSR_Producer");
            
            for (int i = 0; i < nodeList1.getLength(); ++i) {
                Node node = nodeList1.item(i);
                Element tElement1 = (Element) node;
                StringBuilder one=new StringBuilder(tElement1.getAttribute("NIPR_Number"));
                NodeList license1 = tElement1.getElementsByTagName("License");
                
                for (int j = 0; j < license1.getLength(); j++) {
                    Element lic1 = (Element) license1.item(j);
                    String first = lic1.getAttribute("License_Number");
                    String second = lic1.getAttribute("State_Code");
                    String third = lic1.getAttribute("Date_Status_Effective");
                    one.append("-"+first+"-"+second+"-"+third);
                    
                    mapper.put(one.toString(), lic1);
                }
            }
            
            for (int i = 0; i < nodeList2.getLength(); ++i) {
                Node node = nodeList2.item(i);
                Element tElement2 = (Element) node;
                StringBuilder two=new StringBuilder(tElement2.getAttribute("NIPR_Number"));
                NodeList license2 = tElement2.getElementsByTagName("License");
                
                for (int j = 0; j < license2.getLength(); j++) {
                    Element lic2 = (Element) license2.item(j);
                    String first = lic2.getAttribute("License_Number");
                    String second = lic2.getAttribute("State_Code");
                    String third = lic2.getAttribute("Date_Status_Effective");
                    two.append("-"+first+"-"+second+"-"+third);
                    
                    if(mapper.containsKey(two.toString())) {
                    	Node license = ((org.w3c.dom.Document) merged_doc).importNode(lic2, true);
                        root.appendChild(license);
                    }
                }
            }
            
            Transformer tfactory = TransformerFactory.newInstance().newTransformer();
            tfactory.transform(new DOMSource((Node) merged_doc), new StreamResult(new File("mergedfiles.xml")));
	}
		catch(Exception e) {}

}
	
}
