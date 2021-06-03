package com.ruoyi.web.controller.myutils;

import com.alibaba.fastjson.JSONObject;

/**
 * date: 2021/6/3 9:58
 * 说明: 响应实体
 *
 * @author: 薛定谔的猫er
 * @since: JDK 1.8
 */
public class Response {
    private String type;
    private String statusCode;
    private String message;
    private JSONObject data;
    public Response(){

    }

    public Response(String type, String statusCode, String message, JSONObject data) {
        this.type = type;
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "type='" + type + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
