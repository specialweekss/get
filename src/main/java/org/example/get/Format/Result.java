package org.example.get.Format;

import lombok.Data;

@Data
public class Result {
    private int code;//返回编码200成功，400失败
    private String msg;//成功/失败
    private long total;//记录数
    private Object data;//数据

    // 构造函数
    private Result(int code, String msg, long total, Object data) {
        this.code = code;
        this.msg = msg;
        this.total = total;
        this.data = data;
    }

    public static Result fail() {
        return new Result(400,"失败",0L,null);
    }
    public static Result fail(Object data) {
        return new Result(400,"失败",0L,data);
    }
    public static Result fail(Object data,String msg) {
        return new Result(400,msg,0L,data);
    }

    public static Result success(Object data) {
        return new Result(200,"成功",0L,data);
    }
    public static Result success(Object data, long total) {
        return new Result(200,"成功",total,data);
    }
    public static Result success() {
        return new Result(200,"成功",0L,null);
    }
}
