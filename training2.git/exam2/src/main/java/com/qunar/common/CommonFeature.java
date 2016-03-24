package com.qunar.common;


import java.util.Collection;

/**
 * Created by gongxijun on 16-3-17.
 */
public interface CommonFeature {

    //设置高亮字体颜色常量
    static final String[] COLOR_ = {"\033[0;31m", "\033[0m"};

    /**
     * 直接打印到控制台
     */
    public void show();

    /**
     * 复制到相应文本
     */
    public void copy();

    /**
     * 按照某种格式输出
     */
    public void showSpecial();

    /**
     * 解析order语句
     *
     * @param orders cmd语句
     * @return 判断解析是否成功
     */
    public boolean doParsing(String[] orders);
    /**
     * 等待添加新的功能
     */
    /**
     * @return 返回操作后所得结果
     */
    public Collection<Object> getResult();

    public  void SetResult( Collection<Object> result);
}
