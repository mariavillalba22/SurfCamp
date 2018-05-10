package database.XML;

import java.io.File;

import javax.xml.bind.Unmarshaller;
import database.pojo.Instructor;
import javax.xml.bind.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class XMLdb {
 
	private XMLmanager xml;
	
	public XMLdb (XMLmanager xmlman) {
		this.xml = xmlman;
	}
	
	public static boolean javaToXmlDb(javax.xml.bind.Marshaller marshaller, Instructor instructor, File xml) {
		try {
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(instructor,xml);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public static Instructor xmlToJavadb(Unmarshaller unmarshaller, File xml) {
		Instructor instructor = new Instructor() ;
		try {
			instructor = (Instructor) unmarshaller.unmarshal(xml);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return instructor;
	}

	
	
}
