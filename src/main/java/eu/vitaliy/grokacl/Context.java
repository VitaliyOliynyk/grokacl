package eu.vitaliy.grokacl;

import eu.vitaliy.grokacl.model.UserGroupsProvider;
import eu.vitaliy.grokacl.service.AccessControlListReaderWriter;
import eu.vitaliy.grokacl.service.AccessControlListService;

import java.util.Collection;

import static java.util.Arrays.asList;

/**
 * Created by Vitaliy Oliynyk on 24.09.17.
 */
public class Context {
    public AccessControlListService getAccessControlListService() {
        String opengrokAclPath  = System.getProperty("OPENGROK_ACL_PATH");
        if (opengrokAclPath == null) {
            throw new IllegalStateException("Zdefinuj OPENGROK_ACL_PATH! (-DOPENGROK_ACL_PATH=...)");
        }

        AccessControlListReaderWriter accessControlListReaderWriter = new AccessControlListReaderWriter(opengrokAclPath);

        //TODO do usuniecia, zamienic na SPI
        UserGroupsProvider userGroupsProvider = createFakeUserGroupProvider();
        AccessControlListService accessControlListService = new AccessControlListService(accessControlListReaderWriter, userGroupsProvider);
        return accessControlListService;
    }

    //TODO do usuniecia
    private UserGroupsProvider createFakeUserGroupProvider() {
        return new UserGroupsProvider() {
            @Override
            public Collection<String> getGroups() {
                return asList("group1, group2");
            }
        };
    }
}
