package by.it.yaroshevich.jd02_08.samples;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import static javax.xml.stream.XMLStreamConstants.*;

public class StaxDemo {
    public static void main(String[] args) throws IOException, XMLStreamException {
        StringBuilder out = new StringBuilder();
        String tab = "";
        StringBuilder txt = new StringBuilder();
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("app.xml"));) {
            XMLInputFactory factory = XMLInputFactory.newFactory();
            XMLStreamReader reader = factory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int next = reader.next();
                switch (next) {
                    case START_ELEMENT -> {
                        String tag = reader.getLocalName();
                        out.append(tab).append('<').append(tag);
                        int attributeCount = reader.getAttributeCount();
                        if (attributeCount > 0) {
                            for (int i = 0; i < attributeCount; i++) {
                                QName attributeName = reader.getAttributeName(i);
                                String attributeValue = reader.getAttributeValue(i);
                                out.append(" ").append(attributeName).append("=").append(attributeValue);
                            }
                        }
                        out.append(">\n");
                        tab = tab + "\t";
                    }
                    case CHARACTERS -> txt.append(reader.getText().trim());
                    case END_ELEMENT -> {
                        if (!txt.toString().isEmpty()) {
                            out.append(tab).append(txt).append("\n");
                        }
                        txt=new StringBuilder();
                        String tag = reader.getLocalName();
                        tab = tab.substring(1);
                        out.append(tab).append("</").append(tag).append(">\n");
                    }
                }
            }
        }
        System.out.println(out);
    }
}
