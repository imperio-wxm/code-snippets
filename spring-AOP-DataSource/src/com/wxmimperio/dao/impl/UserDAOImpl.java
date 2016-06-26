package com.wxmimperio.dao.impl;

import com.wxmimperio.dao.UserDAO;
import com.wxmimperio.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wxmimperio on 2016/6/19.
 * DAO层的实现
 */

//可以将类当做组件使用
@Component("UserDAOImpl")
public class UserDAOImpl implements UserDAO {

    private DataSource dataSource;
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

    public DataSource getDataSource() {
        return dataSource;
    }

    @Resource
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    Connection connection;

    @Override
    public void save(User user) {
        try {
            String sql = "INSERT INTO user VALUES (null,'测试')";
            //拿到连接
            connection = dataSource.getConnection();
            connection.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("a usr save");
    }

    @Override
    public String toString() {
        return "Sets:" + sets.size() + " Lists:" + lists.size() +
                " Maps:" + maps.size() + " daoId" + daoId;
    }
}
