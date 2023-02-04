package by.it.yaroshevich.jd02_08.samples;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxDemo {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        Handler handler = new Handler();
        saxParser.parse(new File("app.xml"),handler);
        System.out.println(handler.getOut());
    }
}


class Handler extends DefaultHandler {
    private final StringBuilder out = new StringBuilder();
    String tab = "";
    StringBuilder txt = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        out.append(tab).append('<').append(qName);
        int attributeCount = attributes.getLength();
        if (attributeCount > 0) {
            for (int i = 0; i < attributeCount; i++) {
                String attributesQName = attributes.getQName(i);
                String attributeValue = attributes.getValue(i);
                out.append(" ").append(attributesQName).append("=").append(attributeValue);
            }
        }
        out.append(">\n");
        tab = tab + "\t";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String string = txt.toString();
        if (!string.isEmpty()) {
            out.append(tab).append(string).append("\n");
        }
        txt=new StringBuilder();
        tab = tab.substring(1);
        out.append(tab).append("</").append(qName).append(">\n");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        txt.append(new String(ch, start, length).trim());
    }

    public String getOut() {
        return out.toString();
    }
}