package eu.vitaliy.grokacl;

import eu.vitaliy.grokacl.service.AccessControlListService;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by Vitaliy Oliynyk on 25.09.17.
 */
public class ContextTest {

    @Test
    public void getAccessControlListServiceTest() {
        //given
        Context context = new Context();
        System.setProperty(Context.OPENGROK_ACL_PATH, "src/test/resources/GrockAcl.json");

        //when
        AccessControlListService accessControlListService = context.getAccessControlListService();

        //then
        assertThat(accessControlListService).isNotNull();
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void getAccessControlListServiceExceptionTest() {
        //given
        Context context = new Context();

        //when
        AccessControlListService accessControlListService = context.getAccessControlListService();

    }
}
