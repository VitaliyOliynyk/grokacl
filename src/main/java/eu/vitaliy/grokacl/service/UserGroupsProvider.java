package eu.vitaliy.grokacl.service;

import java.util.Collection;

/**
 * Created by Vitaliy Oliynyk on 24.09.17.
 */
public interface UserGroupsProvider {
    Collection<String> getGroups();
}
