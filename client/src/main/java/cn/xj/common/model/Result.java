package cn.xj.common.model;

/**
 * Created by Welink on 2017/4/27.
 */
public class Result extends ResultTemplate {

    public Result() {
        super();
    }

    public Result(String version, String method, Object result) {
        super(version, method, result);
    }

}
