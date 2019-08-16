package top.cllccc.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>通用的相应对象</h1>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    /** 错误码，正确返回0*/
    private  Integer errorCode = 0;

    /** 错误信息，正确返回空字符串 */
    private String errorMsg = "";

    /** 返回对象值*/
    private Object data;

    /**
     * <h2>正确的响应构造函数</h2>
     * @param data 返回值对象
     */
    public Response(Object data){
        this.data = data;
    }

}
