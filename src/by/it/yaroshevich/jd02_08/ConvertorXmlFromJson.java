package by.it.yaroshevich.jd02_08;

import by.it.yaroshevich.jd02_08.config.App;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ConvertorXmlFromJson {

    public static final String FILE_JSON = "file.json";
    public static final String FILE_XML = "file_from_json.xml";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        JsonMapper jsonMapper = new JsonMapper();
        URL url = ConvertorXmlFromJson.class.getResource(FILE_JSON);

        App app = jsonMapper.readValue(url, App.class);
        System.out.println("\nFile JSON\n" + app);

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        //xml as string
        String valueAsString = xmlMapper.writeValueAsString(app);
        System.out.println(valueAsString);

        //write xml
        File xmlFile = new File(FILE_XML);
        xmlMapper.writeValue(xmlFile, app);

        //read xml
        App appFromXmlFile = xmlMapper.readValue(xmlFile, App.class);
        System.out.println("\nFile XML from JSON\n" + appFromXmlFile);
    }

}
