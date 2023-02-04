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
    private static final String INFO_JSON = "info.json";
    private static final String INFO_XML = "info.xml";
    private static final String INFO_YAML = "info.yaml";

    public static void main(String[] args) throws IOException {
        Info info = getInfoClass(new JsonMapper());
        saveToFile(new YAMLMapper(), INFO_YAML, info);
        saveToFile(new XmlMapper(), INFO_XML, info);
        saveToFile(new JsonMapper(), INFO_JSON, info);
    }

    private static Info getInfoClass(ObjectMapper objectMapper) throws IOException {
        String fileName = getFileName(objectMapper);
        URL url = Converter.class.getResource(fileName);
        return objectMapper.readValue(url, Info.class);
    }

    private static String getFileName(ObjectMapper objectMapper) {
        if (objectMapper instanceof XmlMapper) {
            return INFO_XML;
        } else if (objectMapper instanceof JsonMapper) {
            return INFO_JSON;
        }
        return INFO_YAML;
    }

    private static void saveToFile(ObjectMapper objectMapper, String infoFile, Info info) throws IOException {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String valueAsString = objectMapper.writeValueAsString(info);
        System.out.println(valueAsString);
        objectMapper.writeValue(new File(infoFile), info);
    }
}
