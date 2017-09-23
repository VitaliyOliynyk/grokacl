package eu.vitaliy.grokacl;
import eu.vitaliy.grokacl.service.AccessControlListService;
import org.opensolaris.opengrok.authorization.IAuthorizationPlugin;
import org.opensolaris.opengrok.configuration.Group;
import org.opensolaris.opengrok.configuration.Project;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Vitaliy Oliynyk  on 19.09.17.
 */
public class GrokAcl implements IAuthorizationPlugin {
    private AccessControlListService accessControlListService;

    @Override
    public void load() {
        Context context = new Context();
        accessControlListService = context.getAccessControlListService();
        accessControlListService.loadAccessControlList();
    }

    @Override
    public void unload() {
        /* nothing */
    }

    @Override
    public boolean isAllowed(HttpServletRequest httpServletRequest, Project project) {
        return accessControlListService.isAllowed(project.getPath());
    }

    @Override
    public boolean isAllowed(HttpServletRequest httpServletRequest, Group group) {
        return true;
    }
}
