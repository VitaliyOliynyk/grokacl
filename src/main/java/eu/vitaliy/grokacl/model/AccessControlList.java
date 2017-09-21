package eu.vitaliy.grokacl.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
