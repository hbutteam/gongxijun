//region Description
//<editor-fold desc="Description">
//endregion


/**
 * Created by gongxijun on 16-3-12.
 */

public interface Solution {


    public Result getResult();

    /**
     * 统计全部请求
     */
    public void countByRequest();

    /**
     * 最频繁的十个http接口
     *
     * @param uri 链接URL的子项
     */
    public void countMaxHttp(String uri);

    /**
     * 对Map进行value排序
     */
    public void NOfTopHttp(Integer N);

    /**
     * 统计POST　和　get 数量
     *
     * @param type 请求的类型
     */
    public void countPostGetNumber(String type);


    public Integer countClassify();

    /**
     * uri分类
     *
     * @param subUri   URI的前缀
     * @param uri      URI
     * @return 返回当前的不同前缀的种类
     */
    public void countClassifyData(String subUri, String uri);


}
//</editor-fold>
