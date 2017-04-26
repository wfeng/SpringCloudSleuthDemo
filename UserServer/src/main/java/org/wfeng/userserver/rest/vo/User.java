package org.wfeng.userserver.rest.vo;

import java.io.Serializable;

/**
 * Created by wfeng on 2017/4/24.
 */

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public User(String userId, String name) {
        this.id = userId;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
