package com.wxmimperio.jetty.pojo;

/**
 * 结果
 *
 * @author yuanxiaolong.sam
 */
public class Result<T extends Page> {

    private boolean isSuccess;

    private String errorMsg;

    private T result;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
