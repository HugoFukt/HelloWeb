package com.yiibai.springmvc.test.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.yiibai.springmvc.test.URLCon4;

//import com.yiibai.springmvc.test.URLCon;
//import com.yiibai.springmvc.test.URLCon2;
//import com.yiibai.springmvc.test.URLCon3;

public class TestCaseLaunchApiController {

    @Test(groups = {"BaseCase"})
    public void getSecond() throws IOException{
    	String url = "http://192.168.101.34:8081/HelloWeb/hello/user/createUser";
    	String params = "";
    	//String result = URLCon.getConnection(url, params,"GET");
    	//String result = URLCon2.doHttpRequest(url);
    	//String result = URLCon3.isValid(url);
    	String result = URLCon4.sendGet(url, params);
        Reporter.log("リクエストURL: "+ url);
        Reporter.log("結果: "+ result);
        Assert.assertEquals(result,"Hello World!");
    }
    
}
