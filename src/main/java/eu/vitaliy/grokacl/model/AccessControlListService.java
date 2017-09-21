package eu.vitaliy.grokacl.model;

import org.apache.commons.lang3.NotImplementedException;

/**
 * Created by Vitaliy Oliynyk on 21.09.17.
 */
public class AccessControlListService {

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
