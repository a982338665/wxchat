package pers.li.login.wxlogindemo.common;

import lombok.Data;

/**
 * @Description: 自定义响应数据结构
 * 				这个类是提供给门户，ios，安卓，微信商城用的
 * 				门户接受此类数据后需要使用本类的方法转换成对于的数据类型格式（类，或者list）
 * 				其他自行处理
 * 				200：表示成功
 * 				500：表示错误，错误信息在msg字段中
 * 				501：bean验证错误，不管多少个错误都以map形式返回
 * 				502：拦截器拦截到用户token出错
 * 				555：异常抛出信息
 */
@Data
public class JsonResult<T>{

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private T data;
    
    private String ok;	// 不使用

    public static <T> JsonResult build(Integer status, String msg, T data) {
        return new JsonResult(status, msg, data);
    }

    public static <T> JsonResult ok(T data) {
        return new JsonResult(data);
    }

    public static JsonResult ok() {
        return new JsonResult(null);
    }
    
    public static JsonResult errorMsg(String msg) {
        return new JsonResult(500, msg, null);
    }
    
    public static JsonResult errorMap(Object data) {
        return new JsonResult(501, "error", data);
    }
    
    public static JsonResult errorTokenMsg(String msg) {
        return new JsonResult(502, msg, null);
    }
    
    public static JsonResult errorException(String msg) {
        return new JsonResult(555, msg, null);
    }

    public JsonResult() {

    }

    public JsonResult(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(T data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }


}
