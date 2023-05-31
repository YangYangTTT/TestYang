package com.example.test.testyangte.common;

public class AjaxResp {
    private  int code;
    private String msg;
    private Object data;
    public AjaxResp(Object data) {
        this.data = data;
    }

    public AjaxResp(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static AjaxResp error(int code,String msg){
      return new AjaxResp(code,msg);
    }
    public static AjaxResp ok(Object data){
        return new AjaxResp(data);
    }
}
