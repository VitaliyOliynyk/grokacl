package eu.vitaliy.grokacl.service;

import com.google.gson.Gson;
import eu.vitaliy.grokacl.model.AccessControlList;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Vitaliy Oliynyk on 21.09.17.
 */
public class AccessControlListReaderWriter {
    private Gson gson = new Gson();

    @Value("#{environment.OPENGROK_ACL_PATH}")
    private String fileName;


    public AccessControlListReaderWriter() {
    }


    public AccessControlList readAccessControlList() {
        try {
            return readAccessControlListImpl();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void writeAccessControlList(AccessControlList accessControlList) {
        try {
            writeAccessControlListImpl(accessControlList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void writeAccessControlListImpl(AccessControlList accessControlList) throws IOException {
        String content = gson.toJson(accessControlList);
        Files.write(Paths.get(fileName), content.getBytes());
    }

    private AccessControlList readAccessControlListImpl() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        return gson.fromJson(content, AccessControlList.class);
    }
}
