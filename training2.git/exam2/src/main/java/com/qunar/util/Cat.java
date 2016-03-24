package com.qunar.util;

import com.qunar.Abstract.Cats;
import com.qunar.Abstract.AbstractFiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;


/**
 * Created by gongxijun on 16-3-17.
 * 这个类负责打印文本内容，其它啥也不管
 */
public class Cat extends Cats {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Collection<Object> result;

    public Cat() {
    }

    public Cat(Collection<Object> outInf) {
        this.result = outInf;
    }

    public void push(Object value) {
        this.result.add(value);
    }

    @Override
    public void show() {
        /*需要判断泛型类别*/
        if (result == null || result.isEmpty()) {
            logger.error("语句格式有误！");
            return;
        }
        for (Object ans : result)
            logger.info(ans.toString());
    }

    /**
     * 解析shell指令
     * @param order 命令
     * @return true/false 解析是否成功
     */
    @Override
    public boolean doParsing(String[] order) {
         if (order.length > 1) {
            //说明有自己的数据源，忽略输入的源
            AtomicReference<AbstractFiles> fRead = new AtomicReference<AbstractFiles>(new Files(order[1]));
            try {
                result = fRead.get().ReadFile();
            } catch (IOException e) {
                logger.error("前方高能预警！", e);
            }
            if (result.isEmpty()) return false;
        }
        return true;
    }

    @Override
    public Collection<Object> getResult() {
        return result;
    }

    @Override
    public void SetResult(Collection<Object> result) {
        this.result = result;
    }


}
