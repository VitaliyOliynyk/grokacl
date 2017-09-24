package eu.vitaliy.grokacl.service;

import eu.vitaliy.grokacl.Context;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by Vitaliy Oliynyk on 25.09.17.
 */
public class AccessControlListServiceTest {

    @Test(dataProvider = "isAllowedData")
    public void isAllowedTest(String path, boolean expextedResult) {
        //given
        AccessControlListService accessControlListService = init();

        //when
        boolean result = accessControlListService.isAllowed(path);

        //then
        assertThat(result).isEqualTo(expextedResult);
    }

    @DataProvider(name="isAllowedData")
    private Object[][] isAllowedData() {
        return new Object[][] {
                {"/systemA/module1", true},
                {"/systemZ/module1", false},
                {"/systemB/module1", false}
        };
    }

    private AccessControlListService init() {
        Context context = new Context();
        System.setProperty(Context.OPENGROK_ACL_PATH, "src/test/resources/GrockAcl.json");
        AccessControlListService accessControlListService = context.getAccessControlListService();
        accessControlListService.loadAccessControlList();
        return accessControlListService;
    }
}
