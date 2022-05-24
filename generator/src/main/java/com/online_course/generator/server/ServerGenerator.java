package com.online_course.generator.server;

import com.online_course.generator.util.FreemarkerUtil;
import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * @author wenhaoli
 * @date 2022/05/24 16:15
 */
public class ServerGenerator {

    static String toPath = "generator\\src\\main\\java\\com\\online_course\\generator\\test\\";


    public static void main(String[] args) throws IOException, TemplateException {
        FreemarkerUtil.initConfig("test.ftl");
        FreemarkerUtil.generator(toPath+"Test.java");
    }
}
