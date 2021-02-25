import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Validate {
	public static void main(String[] args)
    {
 	   try {
 		   File f1 = new File("file1.xml");
		       File f2 = new File("file2.xml");
		       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		       Document doc1 = (Document) dBuilder.parse(f1);
		       Document doc2 = (Document) dBuilder.parse(f2);
		       ((org.w3c.dom.Document) doc1).getDocumentElement().normalize();
		       ((Node) doc2.getDefaultRootElement()).normalize();  
		       IsValidLicence(doc2, "invalid");
		       IsValidLicence(doc1, "valid");
 	   }
 	   catch(Exception e)
 	   {
 		   e.printStackTrace();
 	   }
    }

	private static void IsValidLicence(Document file, String string) {
		// TODO Auto-generated method stub
		try {
        	NodeList license_list = ((org.w3c.dom.Document) file).getElementsByTagName("License");

            for(int i = 0; i <license_list.getLength(); i++) {
                Node license = license_list.item(i);
                Element licenseElement = (Element) license;

                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String expirationDate = licenseElement.getAttribute("License_Expiration_Date");
                LocalDate licenseExpirationDate = LocalDate.parse(expirationDate, dateTimeFormatter);

                LocalDate today = LocalDate.now();
                int diff = today.compareTo(licenseExpirationDate);

                if(string.equals("valid")) {
                	if(diff > 0) {
                		licenseElement.getParentNode().removeChild(licenseElement);
                	}
                }
                else if(string.equals("invalid")){
                	if(diff < 0) {
                		licenseElement.getParentNode().removeChild(licenseElement);
                	}
                }
            }

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource();
            StreamResult result = new StreamResult(new StringWriter());
            transformer.transform(source, result);
            Writer output = new BufferedWriter(new FileWriter(string + ".xml"));
            String xmlOutput = result.getWriter().toString();
            output.write(xmlOutput);
            output.close();
        }
        catch (Exception e) {

            e.printStackTrace();
        }
		
	}
}
