package Model;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLHandler {
    private static final String FILE_PATH = "data.xml";

    public static void createXMLFile() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("DanhSach");
            doc.appendChild(root);

            saveXMLFile(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addElement(String name, String value) {
        try {
            Document doc = loadXMLFile();
            Element newElement = doc.createElement(name);
            newElement.setTextContent(value);
            doc.getDocumentElement().appendChild(newElement);
            saveXMLFile(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String readXMLFile() {
        StringBuilder result = new StringBuilder();
        try {
            Document doc = loadXMLFile();
            NodeList list = doc.getDocumentElement().getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) list.item(i);
                    result.append(element.getTagName()).append(": ").append(element.getTextContent()).append("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    private static Document loadXMLFile() throws Exception {
        File file = new File(FILE_PATH);
        if (!file.exists()) createXMLFile();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(file);
    }

    private static void saveXMLFile(Document doc) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_PATH));
        transformer.transform(source, result);
    }
}