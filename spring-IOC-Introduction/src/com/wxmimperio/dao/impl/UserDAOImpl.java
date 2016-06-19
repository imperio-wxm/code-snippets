package com.wxmimperio.dao.impl;

import com.wxmimperio.dao.UserDAO;
import com.wxmimperio.model.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wxmimperio on 2016/6/19.
 * DAO层的实现
 */
public class UserDAOImpl implements UserDAO {

    private int daoId;
    private String daoStatus;
    private Set<String> sets;
    private List<String> lists;
    private Map<String, String> maps;

    public int getDaoId() {
        return daoId;
    }

    public void setDaoId(int daoId) {
        this.daoId = daoId;
    }

    public String getDaoStatus() {
        return daoStatus;
    }

    public void setDaoStatus(String daoStatus) {
        this.daoStatus = daoStatus;
    }

    public Set<String> getSets() {
        return sets;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    @Override
    public void save(User user) {
        System.out.println("a usr save");
    }

    @Override
    public String toString() {
        return "Sets:" + sets.size() + " Lists:" + lists.size() +
                " Maps:" + maps.size() + " daoId" + daoId;
    }
}
