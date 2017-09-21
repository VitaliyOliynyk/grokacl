package eu.vitaliy.grokacl;
import org.opensolaris.opengrok.authorization.IAuthorizationPlugin;
import org.opensolaris.opengrok.configuration.Group;
import org.opensolaris.opengrok.configuration.Project;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Vitaliy Oliynyk  on 19.09.17.
 */
public class GrokAcl implements IAuthorizationPlugin {
    @Override
    public void load() {
        System.out.println("Hello! load");
    }

    @Override
    public void unload() {
        System.out.println("Hello! unload");
    }

    @Override
    public boolean isAllowed(HttpServletRequest httpServletRequest, Project project) {
        return true;
    }

    @Override
    public boolean isAllowed(HttpServletRequest httpServletRequest, Group group) {
        return true;
    }
}
