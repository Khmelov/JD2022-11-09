package by.it.han.jd02_08;

import by.it.han.jd02_08.model.Info;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Runner {
    public static final String INFO_JSON = "info.json";
    public static final String INFO_XML = "info.xml";
    public static final String INFO_YAML = "info.yaml";

    public static void main(String[] args) throws IOException {
        Info info = operationYAML();
        operationXML(info);
        operationJSON(info);
    }

    private static Info operationYAML() throws IOException {
        YAMLMapper yamlMapper = new YAMLMapper();
        yamlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        URL url = Runner.class.getResource(INFO_YAML);
        Info info = yamlMapper.readValue(url, Info.class);
        String valueAsString = yamlMapper.writeValueAsString(info);
        System.out.println(valueAsString);
        yamlMapper.writeValue(new File(INFO_YAML), info);
        return info;
    }

    private static void operationXML(Info info) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String valueAsString = xmlMapper.writeValueAsString(info);
        System.out.println(valueAsString);
        File xmlFile = new File(INFO_XML);
        xmlMapper.writeValue(xmlFile, info);
        Info infoFromXmlFile = xmlMapper.readValue(xmlFile, Info.class);
        System.out.println(infoFromXmlFile);
    }

    private static void operationJSON(Info info) throws IOException {
        JsonMapper jsonMapper = new JsonMapper();
        jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String valueAsString = jsonMapper.writeValueAsString(info);
        System.out.println(valueAsString);
        File jsonFile = new File(INFO_JSON);
        jsonMapper.writeValue(jsonFile, info);
        Info infoFromJsonFile = jsonMapper.readValue(jsonFile, Info.class);
        System.out.println(infoFromJsonFile);
    }
}
