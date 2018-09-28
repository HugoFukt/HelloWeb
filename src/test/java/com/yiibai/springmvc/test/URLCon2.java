package com.yiibai.springmvc.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class URLCon2 {
	/*
	 * 解析URL获取返回的字符串信息
	 */
	public static  String doHttpRequest(String url) {
        StringBuffer result = new StringBuffer();
        BufferedReader in = null;
        try {
        	URLConnection connection = null;
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            connection = realUrl.openConnection();
        	// 发送POST请求必须设置如下两行
            connection.setDoOutput(true);
            connection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            PrintWriter out = new PrintWriter(connection.getOutputStream());         
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"GBK"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
                // flush输出流的缓冲
                out.flush();
            }
        } catch (Exception e) {
        }finally {// 使用finally块来关闭输入流
            try { 
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result.toString();
	} 
}
