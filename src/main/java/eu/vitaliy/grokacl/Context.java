package eu.vitaliy.grokacl;

import eu.vitaliy.grokacl.service.UserGroupsProvider;
import eu.vitaliy.grokacl.service.AccessControlListReaderWriter;
import eu.vitaliy.grokacl.service.AccessControlListService;

import java.util.Collection;

import static java.lang.String.format;
import static java.util.Arrays.asList;

/**
 * Created by Vitaliy Oliynyk on 24.09.17.
 */
public class Context {

    public static final String OPENGROK_ACL_PATH = "opengrok.acl.path";

    public AccessControlListService getAccessControlListService() {
        String opengrokAclPath  = System.getProperty(OPENGROK_ACL_PATH);
        if (opengrokAclPath == null) {
            throw new IllegalStateException(format("Zdefinuj %1$s! (-D%1$s=...)", OPENGROK_ACL_PATH));
        }

        AccessControlListReaderWriter accessControlListReaderWriter = new AccessControlListReaderWriter(opengrokAclPath);

        AccessControlListService accessControlListService = new AccessControlListService(accessControlListReaderWriter);
        return accessControlListService;
    }

}
