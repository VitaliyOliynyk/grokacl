package eu.vitaliy.grokacl.test;

import eu.vitaliy.grokacl.Context;

/**
 * Created by Vitaliy Oliynyk on 25.09.17.
 */
public abstract class AbstractGrokAclTest {
    public AbstractGrokAclTest() {
        System.setProperty(Context.OPENGROK_ACL_PATH, "src/test/resources/GrockAcl.json");
    }
}
