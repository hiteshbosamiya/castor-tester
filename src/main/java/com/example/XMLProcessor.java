// File: src/main/java/com/example/XMLProcessor.java
package com.example;

import org.castor.xml.XMLProperties;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.*;
import org.xml.sax.InputSource;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class XMLProcessor {
    public void objectToXML(Object object, String fileName, String mappingFile)
            throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            Marshaller marshaller = getMarshaller(mappingFile);
            marshaller.setWriter(fileWriter);
            marshaller.marshal(object);
        } catch (MarshalException | ValidationException e) {
            throw new IOException(e);
        }
    }

    public Object xmlToObject(String xmlFile, String mappingFile) throws IOException {
        try (FileReader fileReader = new FileReader(xmlFile)) {
            Unmarshaller unmarshaller = getUnmarshaller(mappingFile);
            return unmarshaller.unmarshal(fileReader);
        } catch (MarshalException | ValidationException e) {
            throw new IOException(e);
        }
    }

    public Marshaller getMarshaller(String mappingFile) throws IOException {
        XMLContext context = getXmlContext(mappingFile);
        return context.createMarshaller();
    }

    public Unmarshaller getUnmarshaller(String mappingFile) throws IOException {
        XMLContext context = getXmlContext(mappingFile);
        return context.createUnmarshaller();
    }

    private XMLContext getXmlContext(String mappingFile) throws IOException {
        XMLContext context = new XMLContext();
        context.setProperty(XMLProperties.USE_INDENTATION, "true");
        // Reference: https://github.com/castor-data-binding/castor/issues/78
        context.setProperty(XMLProperties.LENIENT_ID_VALIDATION, "true");
        try {
            context.addMapping(getMapping(mappingFile));
        } catch (MappingException e) {
            throw new IOException(e);
        }
        return context;
    }

    private Mapping getMapping(String mappingFile) throws IOException {
        InputStream mapStream = this.getClass().getResourceAsStream(mappingFile);
        if (mapStream == null) {
            String msg = "Mapping file " + mappingFile + " not found.";
            System.out.println(msg);
            throw new IOException(msg);
        }

        Mapping mapping = new Mapping();
        InputSource mapSource = new InputSource(mapStream);
        mapping.loadMapping(mapSource);
        return mapping;
    }
}
