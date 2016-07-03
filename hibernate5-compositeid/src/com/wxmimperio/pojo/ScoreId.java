package com.wxmimperio.pojo;

import java.io.Serializable;

/**
 * Created by wxmimperio on 2016/7/3.
 * 必须实现序列化接口
 */
public class ScoreId implements Serializable {
    private String stuId;//学生编号
    private String objectId;//课程编号

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    /**
     * 重写hashcode、equals
     *
     * @return
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
