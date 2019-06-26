package com.stduy.springBoot.sms.controler;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author zhu_f  E-mail: zhu_fujian@163.com
 * @version 创建时间：2019年6月26日 上午10:22:54
 * 类说明
 */
@RestController
@Api("云通信消息接收")
@Slf4j
@RequestMapping(value = "/receive/")
public class ReceiveControler {

	@PostMapping("aliYStatusMsg")
	@ApiOperation(value = "状态报告接收")
	public void aliYStatusMsg( @RequestBody JSONArray req,HttpServletResponse response){
		log.info("receiveAliYStatus>>>>>>>>>>>>"+JSON.toJSONString(req));
		write(response);
		//http://nmcn6w.natappfree.cc/receive/aliYStatusMsg
		//receiveAliYStatus>>>>>>>>>>>>[{"send_time":"2017-08-30 00:00:00","report_time":"2017-08-30 00:00:00","success":true,"err_msg":"用户接收成功","err_code":"DELIVERED","phone_number":"18612345678","sms_size":"1","biz_id":"932702304080415357^0","out_id":"1184585343"}]
	     //响应报文>>>>>>>>>>>>{"msg":"成功","code":0}
		return;
	}
	
	@PostMapping("aliYMsg")
	@ApiOperation(value = "上行消息接收")
	public void aliYMsg( @RequestBody JSONArray req,HttpServletResponse response){
		log.info("aliYMsg>>>>>>>>>>>>"+JSON.toJSONString(req));
		
		write(response);
	       
		//http://nmcn6w.natappfree.cc/receive/aliYMsg
		//aliYMsg>>>>>>>>>>>>[{"phone_number":"18612345678","content":"内容","send_time":"2017-08-30 00:00:00","dest_code":"1234","sequence_id":"1234567890"}]
		//响应报文>>>>>>>>>>>>{"msg":"成功","code":0}
		return;
	}
	/**
	 * 
	 * @param response
	 */
	private void write(HttpServletResponse response){
		  HttpServletResponse res = (HttpServletResponse) response;
		  PrintWriter out = null;
	        try {
	            out = response.getWriter();
	            res.setHeader("Access-Control-Allow-Origin", "*");
	            res.setStatus(HttpServletResponse.SC_OK);
	            res.setCharacterEncoding("UTF-8");
	            res.setContentType("application/json; charset=utf-8");
	            JSONObject resObj= new JSONObject();
	            resObj.put("code", 0);
	            resObj.put("msg", "成功");
	            log.info("响应报文>>>>>>>>>>>>"+JSON.toJSONString(resObj));
	            out.println(resObj);
	            // 当发送错误状态码时，Tomcat会跳转到固定的错误页面去，但可以
	        } catch (Exception e) {
	        } finally {
	            if (null != out) {
	                out.flush();
	                out.close();
	            }
	        }
	}
}
