package com.baidu.translate.demo;

import java.io.UnsupportedEncodingException;


public class Main {

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20191129000361644";
    private static final String SECURITY_KEY = "Cn6eAB68fMczpCe5Oy3a";

    public static void main(String[] args) throws UnsupportedEncodingException {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        String query = "高度600米";
        System.out.println(api.getTransResult(query, "auto", "en"));
    }

}
