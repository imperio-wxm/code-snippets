package com.wxmimperio.mybatis.pojo;

/**
 * Created by wxmimperio on 2016/10/7.
 */
public class Order {
    private int id;
    private int consumerId;
    private int goodsId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }
}
