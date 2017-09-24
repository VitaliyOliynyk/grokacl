package eu.vitaliy.grokacl.service;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Vitaliy Oliynyk on 25.09.17.
 */
public class UserGroupsProviderSpiLoader {
    public static UserGroupsProvider load() {
        ServiceLoader<UserGroupsProvider> loader = ServiceLoader.load(UserGroupsProvider.class);
        List<UserGroupsProvider> userGroupsProviders =
        StreamSupport.stream(loader.spliterator(), false)
                .collect(Collectors.toList());
        int size = userGroupsProviders.size();

        if (size != 1) {
            throw new IllegalStateException("Musi byc zdefinowany tylko jeden obiekt " + UserGroupsProvider.class.getName());
        }
        return userGroupsProviders.get(0);
    }
}
