package eu.vitaliy.grokacl.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vitaliy Oliynyk  on 21.09.17.
 */
public class AccessControlList implements Serializable{
    List<Access> controlList = new ArrayList<>();

    public AccessControlList() {
    }

    public AccessControlList(List<Access> controlList) {
        this.controlList = controlList;
    }

    public List<Access> getControlList() {
        return controlList;
    }

    public void setControlList(List<Access> controlList) {
        this.controlList = controlList;
    }
}
