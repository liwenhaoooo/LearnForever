package com.online_course.generator.server;

import com.online_course.generator.util.FreemarkerUtil;
import freemarker.template.TemplateException;
import sun.security.pkcs11.Secmod;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author wenhaoli
 * @date 2022/05/24 16:15
 */
public class ServerGenerator {

    static  String MODULE = "business";
    static String toServicePath = "server\\src\\main\\java\\com\\online_course\\server\\service\\";
    static String toControllerPath = MODULE+"\\src\\main\\java\\com\\online_course\\"+MODULE+"\\controller\\admin\\" ;


    public static void main(String[] args) throws IOException, TemplateException {
        String Domain = "Section";
        String domain = "section";
        String tableNameCn = "小节";
        String module = MODULE;
        HashMap<String, Object> map = new HashMap<>();
        map.put("Domain",Domain);
        map.put("domain",domain);
        map.put("tableNameCn", tableNameCn);
        map.put("module",module);
        //生成service
        FreemarkerUtil.initConfig("service.ftl");
        FreemarkerUtil.generator(toServicePath+Domain+"Service.java",map);

        //生成controller
        FreemarkerUtil.initConfig("controller.ftl");
        FreemarkerUtil.generator(toControllerPath+Domain+"Controller.java",map);
    }
}
