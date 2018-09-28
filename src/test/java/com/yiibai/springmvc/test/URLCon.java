package com.yiibai.springmvc.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * httpリクエスト
 * 
 * @author P0125909
 *
 */
public class URLCon {

    public static String getConnection(String uri, String params, String method) {
//        LaunchAgreeSubApiResVO outBean = new LaunchAgreeSubApiResVO();
        String a = "";
        String responseCode = "";
        try {
            // String obj = "{\"pmIpadUserCD\":\"iPad\"}";
            System.out.println(params);
            // url
            // URL url = new URL("http://192.168.101.56:8080/api/list");
            URL url = new URL(uri);
            // create http 連接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 出力を許可する
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // キャッシュなし
            conn.setUseCaches(false);
            // 配送方法を設ける
            conn.setRequestMethod(method);
            // 長い接続を維持する
            conn.setRequestProperty("Connection", "Keep-Alive");
            // 文書文字集を設置する
            conn.setRequestProperty("Charset", "UTF-8");
            // バイト数組に転換する
            byte[] data = (params.toString()).getBytes();
            // 書類の長さを設定する
            conn.setRequestProperty("Content-Length", String.valueOf(data.length));
            if (method.equals("GET")) {

            } else if (method.equals("POST")) {
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Accept", "application/json");
                conn.setRequestProperty("x-minefocus-app", "ios jp.shiroyagi.kamelio 1.0.0");
                conn.setRequestProperty("x-device-machine-name", "iPhone8;11.1.2");
            } else if (method.equals("PUT")) {

            }


            // ファイルタイプを設定する
            // conn.setRequestProperty("contentType", "application/json");
            // conn.setRequestProperty("Content-Type","application/json;
            // charset=UTF-8");
          

            // 接続要求を開始する
            conn.connect();
            OutputStream out = conn.getOutputStream();
            // 記入要求の文字列
            out.write((params.toString()).getBytes());
            out.flush();
            out.close();
            System.out.println("״状態コード" + conn.getResponseCode());
            responseCode = String.valueOf(conn.getResponseCode());
            // 戻ってきた状態
            if (conn.getResponseCode() == 201) {
                System.out.println("継続しました");
                // 戻ってきたデータ
                InputStream in = conn.getInputStream();
                // String a = null;
                try {
                    byte[] data1 = new byte[in.available()];
                    in.read(data1);
                    // 文字列
                    a = new String(data1);
//                    ObjectMapper  objectMapper = new ObjectMapper();
//                    outBean = objectMapper.readValue(a, LaunchAgreeSubApiResVO.class);
//                    System.out.println(a);

                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            } else {
                System.out.println("no++");
            }
        } catch (Exception e) {

        }
        return a;

    }

}