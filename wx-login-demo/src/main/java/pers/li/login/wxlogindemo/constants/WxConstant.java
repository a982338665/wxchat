package pers.li.login.wxlogindemo.constants;


import pers.li.login.wxlogindemo.utils.PropertiesUtils;

/**
 * create by lishengbo 2018/11/19
 */
public class WxConstant {

    public final static String WX_URI_KEY        = "uri";
    public final static String WX_APPID_KEY      = "appid";
    public final static String WX_SECRET_KEY     = "secret";
    public final static String WX_JS_CODE_KEY    = "js_code";
    public final static String WX_GRANT_TYPE_KEY = "grant_type";

    public final static String WX_URI_VAL = PropertiesUtils.getStaticProperty(WX_URI_KEY);
    public final static String WX_APPID_VAL =  PropertiesUtils.getStaticProperty(WX_APPID_KEY);
    public final static String WX_SECRET_VAL=  PropertiesUtils.getStaticProperty(WX_SECRET_KEY);
    public final static String WX_GRANT_TYPE_VAL =  PropertiesUtils.getStaticProperty(WX_GRANT_TYPE_KEY);

}
