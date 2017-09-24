package eu.vitaliy.grokacl.service;

import java.util.Collection;

import static java.util.Arrays.asList;

/**
 * Created by Vitaliy Oliynyk on 25.09.17.
 */
public class FakeUserGroupsProvider implements UserGroupsProvider {
    @Override
    public Collection<String> getGroups() {
        return asList("group1");
    }
}
