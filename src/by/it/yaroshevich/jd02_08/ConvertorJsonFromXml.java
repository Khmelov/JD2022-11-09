package by.it.yaroshevich.jd02_08;

import by.it.yaroshevich.jd02_08.config.App;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.net.URL;

public class ConvertorJsonFromXml {

    public static final String FILE_XML = "file.xml";
    public static final String FILE_JSON = "file_from_xml.json";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        XmlMapper xmlMapper = new XmlMapper();
        URL url = ConvertorJsonFromXml.class.getResource(FILE_XML);

        App app = xmlMapper.readValue(url, App.class);
        System.out.println("\nFile XML\n" + app);

        //write json
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File jsonFile = new File(FILE_JSON);
        jsonMapper.writeValue(jsonFile, app);

        //read json
        App jsonApp = jsonMapper.readValue(jsonFile, App.class);
        System.out.println("\nFile JSON from XML\n" + jsonApp);

    }
}
