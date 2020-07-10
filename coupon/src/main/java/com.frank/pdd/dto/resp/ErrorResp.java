package com.frank.pdd.dto.resp;

import lombok.Builder;
import lombok.Data;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 16:27 2020-05-26
 * @ Description：错误数据返回值
 * @ Modified By：
 */
@Data
@Builder
public class ErrorResp {


    private String error_msg;//公共参数错误:type
    private String sub_msg;
    private String sub_code;
    private String error_code;
    private String request_id;

//    {
//        "error_response": {
//        "error_msg": "公共参数错误:type",
//                "sub_msg": "",
//                "sub_code": null,
//                "error_code": 10001,
//                "request_id": "15440104776643887"
//    }
//    }
}
