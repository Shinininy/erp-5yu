package com.example.sdorder.configuration;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.http.HttpStatus;

import java.io.Serializable;

@Data
public class R<V> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "中文状态描述")
    private String msg;

    @ApiModelProperty(value = "返回前端数据体")
    private V data;

    private R(int code, Boolean success, String msg) {
        this.code = code;
        this.success = success;
        this.msg = msg;
    }

    private R(int code, Boolean success, String msg, V data) {
        this.code = code;
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    /**
     * [返回状态码和具体的数据] <br>
     */
    public static <V> R<V> success(V data) {
        return new R<V>(0, true, "success", data);
    }

    /**
     * [返回状态码和具体的数据] <br>
     */
    public static <V> R<V> success(String msg, V data) {
        return new R<V>(0, true, msg, data);
    }

    /**
     * [返回成功的状态] <br>
     */
    public static <V> R<V> success() {
        return new R<V>(0, true, "success");
    }

    /**
     * [操作失败] <br>
     */
    public static <V> R<V> fail() {
        return new R<V>(HttpStatus.SC_INTERNAL_SERVER_ERROR, false, "fail");
    }

    public static <V> R<V> fail(String msg) {
        return new R<V>(HttpStatus.SC_INTERNAL_SERVER_ERROR, false, msg);
    }

    /**
     * [自定义失败码和失败原因] <br>
     */
    public static <V> R<V> failed(int code, String msg) {
        return new R<V>(code, true, msg);
    }
}
