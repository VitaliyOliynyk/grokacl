package eu.vitaliy.grokacl.service;

import eu.vitaliy.grokacl.model.Access;
import eu.vitaliy.grokacl.model.AccessControlList;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by Vitaliy Oliynyk on 21.09.17.
 */


public class AccessControlListService {
    private Map<String, Access> pathToGroupMap;


    @Autowired
    private AccessControlListService accessControlListService;

    private AccessControlList accessControlList;
    public void loadAccessControlList() {
        throw new NotImplementedException("");
    }

    public boolean isAllowed(String aclGroup, String path) {
        throw new NotImplementedException("");
    }

    public AccessControlList getAccessControlList() {
        return accessControlList;
    }
}
