package com.qunar.domain;

import com.google.common.collect.Maps;
import com.qunar.Abstract.AbstractParsing;
import com.qunar.common.CommonFeature;
import com.qunar.util.Cat;
import com.qunar.util.Grep;
import com.qunar.util.Wc;

import java.util.Map;


/**
 * Created by gongxijun on 16-3-17.
 */
public abstract class ParsingS implements AbstractParsing {

    public static final String _CONTEXT;
    static {
        _CONTEXT = "\n" +
                "使用说明：此程序仅实现linux命令中的 cat , wc ,grep 三个指令的部分功能\n" +
                "在工程中包含了一共测试文件test ,可以使用次文件进行相关功能的测试，测试样例： cat test | grep google |wc\n" +
                "若想终止程序，请输入exit指令";
    }

     static Map<String, CommonFeature> orderConfig = Maps.newHashMap();
    {
        orderConfig.put("cat", new Cat());
        orderConfig.put("wc", new Wc());
        orderConfig.put("grep", new Grep());
    }

    /**
     * 读取Command
     */
    public abstract void readCommand();

    /**
     * 解析字符串
     */
    public abstract boolean ParseCommand(String order);

}
