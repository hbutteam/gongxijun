package com.qunar.Abstract;

import java.io.IOException;
import java.util.List;

/**
 * Created by gongxijun on 16-3-17.
 */
public interface AbstractFiles {

    /**
     * @return 文件内容
     */
    List<Object> ReadFile() throws IOException;
}
