package eu.vitaliy.grokacl;
import eu.vitaliy.grokacl.service.AccessControlListService;
import org.opensolaris.opengrok.authorization.IAuthorizationPlugin;
import org.opensolaris.opengrok.configuration.Group;
import org.opensolaris.opengrok.configuration.Project;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Vitaliy Oliynyk  on 19.09.17.
 */
public class GrokAcl implements IAuthorizationPlugin {
    private AccessControlListService accessControlListService;

    @Override
    public void load() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/grokacl-context.xml");
        accessControlListService = context.getBean("accessControlListService", AccessControlListService.class);
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
