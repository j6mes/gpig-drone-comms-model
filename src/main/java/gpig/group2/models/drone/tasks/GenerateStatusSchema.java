package gpig.group2.models.drone.tasks;

import gpig.group2.models.drone.status.DroneStatusMessage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

/**
 * Created by james on 20/05/2016.
 */
public class GenerateStatusSchema {
    public static void main(final String[] args) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(DroneStatusMessage.class);


        jaxbContext.generateSchema(new SchemaOutputResolver() {
            @Override
            public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                File file = new File(args[0]);
                file.createNewFile();
                StreamResult result = new StreamResult(file);
                result.setSystemId(file.toURI().toURL().toString());
                return result;
            }
        });

    }
}
