package com.baidu.translate.demo;

import java.util.HashMap;
import java.util.Map;

public class TransApi {
    //这里是百度翻译API的URL地址
    private static final String TRANS_API_HOST = "http://api.fanyi.baidu.com/api/trans/vip/translate";

    //如果要使用百度翻译API，那么必须要拥有appid和securityKey
    private String appid;
    private String securityKey;

    //构造方法
    public TransApi(String appid, String securityKey) {
        this.appid = appid;
        this.securityKey = securityKey;
    }

    //query是需要查询的内容，from是设置原本的语言，to是目标语言，使用HttpGet来发送请求和得到结果。
    public String getTransResult(String query, String from, String to) {
        Map<String, String> params = buildParams(query, from, to);
        return HttpGet.get(TRANS_API_HOST, params);
    }

    private Map<String, String> buildParams(String query, String from, String to) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);

        params.put("appid", appid);

        // 随机数
        String salt = String.valueOf(System.currentTimeMillis());
        params.put("salt", salt);

        // 签名
        String src = appid + query + salt + securityKey; // 加密前的原文
        params.put("sign", MD5.md5(src));

        return params;
    }

}
