package database.XML;

import javax.xml.bind.JAXBContext;
import javax.xml.transform.Transformer;
import javax.xml.bind.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

import org.eclipse.persistence.exceptions.JAXBException;

import java.io.File;
import com.sun.xml.internal.ws.util.Pool.Marshaller;
import com.sun.xml.internal.ws.util.Pool.Unmarshaller;

import database.pojo.Instructor;

public class XMLmanager {

	private JAXBContext jaxb;
	private javax.xml.bind.Marshaller marshaller;
	private javax.xml.bind.Unmarshaller unmarshaller;
	private File xml = new File("./xml/Instructor.xml");
	private XMLdb xmldb = new XMLdb(this);
	
	public XMLmanager () throws javax.xml.bind.JAXBException {
			jaxb = JAXBContext.newInstance(Instructor.class);
			marshaller = jaxb.createMarshaller();
			
			unmarshaller = jaxb.createUnmarshaller();
	}
	
	public boolean marshalldb(Instructor instructor) {
	 	try {
	 		return XMLdb.javaToXmlDb(marshaller,instructor,xml);
	 	}catch(Exception e) {
	 		e.printStackTrace();
	 	}
	 	return false;
	}
	
	public Instructor unmarshalldb(File file) {
	Instructor instructordb = new Instructor();
		try {
			instructordb = XMLdb.xmlToJavadb(unmarshaller, file);
		}catch(Exception e) {
	 		e.printStackTrace();
	 	}
		return instructordb;
		
	}
	
	public static boolean simpleTransform(String sourcePath, String xsltPath,String resultDir) {
		Boolean h = false;
		TransformerFactory tFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = tFactory.newTransformer(new StreamSource(new File(xsltPath)));
			transformer.transform(new StreamSource(new File(sourcePath)),new StreamResult(new File(resultDir)));
			h = true;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return h;
	}
	
	
	
	
	
}
