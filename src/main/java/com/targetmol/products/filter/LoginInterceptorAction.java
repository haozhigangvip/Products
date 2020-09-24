package com.targetmol.products.filter;

import com.targetmol.products.utils.ExceptionEumn;
import com.targetmol.products.utils.JsonUtils;
import com.targetmol.products.utils.MD5Util;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
@Component
public class LoginInterceptorAction implements HandlerInterceptor {
    Logger log = Logger.getLogger(LoginInterceptorAction.class.getName());
    String authKey=("${auth.key}");

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag=false;
        String sign = request.getParameter("sign");
        String time=request.getParameter("time");
        if(sign!=null && time!=null && checkSign(sign,time)==true ){
            flag=true;
        }else{
            responseError(response,ExceptionEumn.AUTHORIZATION_FAILD);
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
//        localDate.getTime()-Long.parseLong(time)<6000;
//
//        if(localDate.compareTo(remoteDate)>6000){
//            log.info("秘钥不匹配");
//            return false;
//        }

        //比对秘钥
        if(sign.equals(getLocalToken(authKey,time))==true){
            return true;

        }else{
            log.info("秘钥不匹配");
        }
        return false;

    }

    //拒绝访问
    private void responseError(HttpServletResponse response, ExceptionEumn eumn) throws IOException {
        Map<String,Object> mp=new HashMap<>();
        response.setStatus(403);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
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
