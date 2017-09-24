package eu.vitaliy.grokacl.service;

import eu.vitaliy.grokacl.model.AccessControlList;

/**
 * Created by Vitaliy Oliynyk on 21.09.17.
 */
public class AccessControlListService {
    private AccessControlList accessControlList;
    private AccessControlListReaderWriter accessControlListReaderWriter;
    private UserGroupsProvider userGroupsProvider;

    public AccessControlListService(AccessControlListReaderWriter accessControlListReaderWriter) {
        this.accessControlListReaderWriter = accessControlListReaderWriter;
        this.userGroupsProvider = getUserGroupsProvider();
    }

    public void loadAccessControlList() {
        accessControlList = accessControlListReaderWriter.readAccessControlList();
    }

    public boolean isAllowed(String path) {
        if (accessControlList == null) {
            throw new IllegalStateException("Najpierw wywolaj metode loadAccessControlList");
        }

        return accessControlList.getControlList()
                .stream()
                .anyMatch(access ->
                        userGroupsProvider.getGroups().contains(access.getGroup())
                        && access.getPaths().stream().anyMatch(path::matches)
                );

    }

    public AccessControlList getAccessControlList() {
        return accessControlList;
    }

    public UserGroupsProvider getUserGroupsProvider() {
        return UserGroupsProviderSpiLoader.load();
    }
}
