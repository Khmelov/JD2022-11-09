package by.it._examples_.jd02_08;

import by.it._examples_.jd02_08.config.App;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.*;
import java.net.URL;

public class DemoConverter {

    public static final String APP_YAML = "app.yaml";
    public static final String APP_DAT = "app.dat";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        YAMLMapper yamlMapper = new YAMLMapper();
        URL url = DemoConverter.class.getResource(APP_YAML);

        App app = yamlMapper.readValue(url, App.class);
        System.out.println("\nApp YAML\n" + app);

        yamlMapper.writeValue(new File(APP_YAML),app);

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(APP_DAT))) {
            objectOutputStream.writeObject(app);
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(APP_DAT))) {
            App appIO = (App) objectInputStream.readObject();
            System.out.println("\nAppIO\n" + appIO);
        }

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        //xml as string
        String valueAsString = xmlMapper.writeValueAsString(app);
        System.out.println(valueAsString);

        //write xml
        File xmlFile = new File("app.xml");
        xmlMapper.writeValue(xmlFile, app);

        //read xml
        App appFromXmlFile = xmlMapper.readValue(xmlFile, App.class);
        System.out.println("\nApp from XML\n" + appFromXmlFile);

        //write json
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File jsonFile = new File("app.json");
        jsonMapper.writeValue(jsonFile, app);

        //read json
        App jsonApp = jsonMapper.readValue(jsonFile, App.class);
        System.out.println("\nApp from json\n" + jsonApp);

        //find one value
        String user = jsonMapper
                .readTree(jsonFile)
                .findValue("user")
                .asText();
        System.out.println("user=" + user);
    }
}
