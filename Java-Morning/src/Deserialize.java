import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Deserialize {

	public static void main(String[] args) throws IOException {
		
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		String path = "C:\\Users\\yashw\\eclipse-workspace\\XML_Demo\\src\\student.xml";
		
		File xmlFile = new File(path);
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
		try {
	        
			dBuilder = dbFactory.newDocumentBuilder();
            
            org.w3c.dom.Document doc = dBuilder.parse(xmlFile); 
            ((org.w3c.dom.Document) doc).getDocumentElement().normalize();
	   
            
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());  

            NodeList nodeList = doc.getElementsByTagName("student");  

            for (int itr = 0; itr < nodeList.getLength(); itr++)   
            {  
            Node node = nodeList.item(itr);  
           // System.out.println("\nNode Name :" + node.getNodeName());  
            if (node.getNodeType() == Node.ELEMENT_NODE)   
            {  
            Element eElement = (Element) node;  
           // System.out.println("Roll number: "+ eElement.getElementsByTagName("roll").item(0).getTextContent());  
           // System.out.println("Marks: "+ eElement.getElementsByTagName("marks").item(0).getTextContent());  
           // System.out.println("Subject: "+ eElement.getElementsByTagName("subject").item(0).getTextContent());  
            
            int roll = Integer.parseInt(eElement.getElementsByTagName("roll").item(0).getTextContent());
            int marks = Integer.parseInt(eElement.getElementsByTagName("marks").item(0).getTextContent());
            
            if(map.containsKey(roll)) {
            	int prev = map.get(roll);
            	map.put(roll ,prev + marks );
            }
            else {
            	map.put(roll,marks);
            }
            
            }  
            }  
            
	       System.out.println(map);
	    } catch (IOException e) {
	        // handle the exception
	    	System.out.println("In catch");
	    } catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Serializing data into text file student.txt
		System.out.println("Serializing.........");
		try {
            FileWriter writer = new FileWriter("./student.txt", true);
            System.out.println("File created");
            for(int roll:map.keySet()) {
            	writer.write(roll +","+map.get(roll));
            	 writer.write("\r\n"); 
            }
            
             
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Some error");
        }

	}

}
