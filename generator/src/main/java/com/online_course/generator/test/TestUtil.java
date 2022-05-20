package com.online_course.generator.test;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author wenhaoli
 * @date 2022/05/20 10:22
 */
public class TestUtil {
    //ftlPath 模板文件所在路径
    static String ftlPath = "generator\\src\\main\\java\\com\\online_course\\generator\\test\\";
    //toPath  要生成的文件的路径
    static String toPath = "generator\\src\\main\\java\\com\\online_course\\generator\\test\\";

    public static void main(String[] args) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setDirectoryForTemplateLoading(new File(ftlPath));//读模板所在路径
        cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_29));
        Template temp = cfg.getTemplate("test.ftl");//读路径下的具体模板

        FileWriter fw = new FileWriter(toPath + "Test.java");
        BufferedWriter bw = new BufferedWriter(fw);
        temp.process(null, bw);
        bw.flush();
        fw.close();
    }
}
