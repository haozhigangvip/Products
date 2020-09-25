package com.targetmol.products.filter;

import com.targetmol.products.utils.JsonUtils;
import com.targetmol.products.utils.MD5Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.*;
@Component
public class LoginInterceptorAction implements HandlerInterceptor {
    @Value("${auth.Key}")
    private String authKey ;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag=false;
        String sign = request.getParameter("sign");
        String time=request.getParameter("time");
        if(sign!=null && time!=null && checkSign(sign,time)==true ){
            flag=true;
        }else{
            responseError(response);
        }

        return flag;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
    //验证 sign
    public boolean checkSign(String sign,String time){
        if(StringUtil.isEmpty(sign)||StringUtil.isEmpty(time)){
            return false;
        }

        //计算请求时间与服务器时间相差是否大于60秒
        Date localDate=new Date(System.currentTimeMillis());
        Date remoteDate=new Date(Long.parseLong(time));
        Long cz=Math.abs(localDate.getTime()-remoteDate.getTime());

        if(cz>60000 || cz<0 ){
            System.out.println("对方请求时间："+remoteDate.toString());
            System.out.println("我方服务器时间："+localDate.toString());
            System.out.println(remoteDate.getTime());
            System.out.println(localDate.getTime());
            System.out.println("鉴权失败！！！！");
            return false;
        }

        //比对秘钥
        String localsign=getLocalToken(authKey,time);
        if(sign.toUpperCase().equals(localsign)==true){
            return true;
        }else {
            System.out.println(localDate.toString()+"  对方请求验证码："+sign);
            System.out.println(localDate.toString()+"  我方验证码："+localsign);
            System.out.println(localDate.toString()+"  鉴权失败！！！！");
        }
        return false;

    }

    //拒绝访问
    private void responseError(HttpServletResponse response) throws IOException {
        Map<String,Object> mp=new HashMap<String,Object>();
        response.setStatus(403);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        mp.put("code",0);
        mp.put("message","鉴权失败");

        response.getWriter().write(JsonUtils.serialize(mp));
    }
    private String getLocalToken(String key,String time){
        //秘钥生成准则：自定义KEY+时间戳（timeStamp）
        return MD5Util.encrypt(key+time);
    }
}
