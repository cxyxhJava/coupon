package com.frank.pdd.dto.req;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 16:02 2020-05-26
 * @ Description：
 * @ Modified By：
 */
public class BaseReq {
    private String type;//必填	API接口名称
    private String client_id;//必填	POP分配给应用的client_id
    private String  access_token;//非必填	通过code获取的access_token(无需授权的接口，该字段不参与sign签名运算)
    private String timestamp;//必填	UNIX时间戳，单位秒，需要与拼多多服务器时间差值在10分钟内
    private String data_type;//非必填	响应格式，即返回数据的格式，JSON或者XML（二选一），默认JSON，注意是大写
    private String version;//非必填	API协议版本号，默认为V1，可不填
    private String sign;//必填	API输入参数签名结果，签名算法参考开放平台接入指南第三部分底部。
}
