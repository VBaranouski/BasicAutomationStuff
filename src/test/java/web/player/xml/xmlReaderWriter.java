package web.player.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.FileOutputStream;

@XmlRootElement
public class xmlReaderWriter {
    private String title;
    private String description;


    public xmlReaderWriter() { }

    public xmlReaderWriter(String title, String description) {
        this.description = description;
        this.title = title;
    }

    @XmlElement
    public String getDescritpion() {
        return description;
    }

    @XmlElement
    public String getTitle() {
        return title;
    }

    public static void saveToXml() throws Exception {

        JAXBContext contextObj = JAXBContext.newInstance(xmlReaderWriter.class);
        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        xmlReaderWriter pmt1 = new xmlReaderWriter("title 1", "description 1");
        marshallerObj.marshal(pmt1, new FileOutputStream("xmlCreationTest.xml"));

    }


    public static void readFromXml() throws Exception {
        File file = new File("xmlCreationTest.xml");
        JAXBContext context = JAXBContext.newInstance(xmlReaderWriter.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        xmlReaderWriter e = (xmlReaderWriter) unmarshaller.unmarshal(file);
        System.out.println(e.getTitle() + ", " + e.getDescritpion());

    }


}