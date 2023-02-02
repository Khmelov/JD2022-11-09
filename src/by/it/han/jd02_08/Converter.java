package by.it.han.jd02_08;

import by.it.han.jd02_08.model.Info;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Converter {
    public static final String INFO_JSON = "info.json";
    public static final String INFO_XML = "info.xml";
    public static final String INFO_YAML = "info.yaml";

    public static void main(String[] args) throws IOException {
        Info info = getInfoClass();
        saveToFile(new YAMLMapper(), INFO_YAML, info);
        saveToFile(new XmlMapper(), INFO_XML, info);
        saveToFile(new JsonMapper(), INFO_JSON, info);
    }

    private static Info getInfoClass() throws IOException {
        YAMLMapper yamlMapper = new YAMLMapper();
        URL url = Converter.class.getResource(Converter.INFO_YAML);
        return yamlMapper.readValue(url, Info.class);
    }

    private static void saveToFile(ObjectMapper objectMapper, String infoFile, Info info) throws IOException {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String valueAsString = objectMapper.writeValueAsString(info);
        System.out.println(valueAsString);
        objectMapper.writeValue(new File(infoFile), info);
    }
}
