package pers.li.login.wxlogindemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.li.login.wxlogindemo.common.HttpClientUtil;
import pers.li.login.wxlogindemo.common.JsonResult;
import pers.li.login.wxlogindemo.common.JsonUtils;
import pers.li.login.wxlogindemo.common.RedisOperator;
import pers.li.login.wxlogindemo.constants.WxConstant;
import pers.li.login.wxlogindemo.model.WXSessionModel;

import java.util.HashMap;
import java.util.Map;


@RestController
public class WXLoginController {

	@Autowired
	private RedisOperator redis;


	/**
	 * 接口报错:
	 * APPID不相同报错: -->修改appId
	 * 	{"errcode":40029,"errmsg":"invalid code, hints: [ req_id: GSj2HA0034hb27 ]"}
	 *
	 *
	 * @param code
	 * @return
	 */
	@PostMapping("/wxLogin")
	public JsonResult wxLogin(String code) {

		System.out.println("wxlogin - code: " + code);

		String url = WxConstant.WX_URI_VAL;
		Map<String, String> param = new HashMap<>();
		param.put(WxConstant.WX_APPID_KEY, WxConstant.WX_APPID_VAL);
		param.put(WxConstant.WX_SECRET_KEY, WxConstant.WX_SECRET_VAL);
		param.put(WxConstant.WX_JS_CODE_KEY, code);
		param.put(WxConstant.WX_GRANT_TYPE_KEY, WxConstant.WX_GRANT_TYPE_VAL);

		String wxResult = HttpClientUtil.doGet(url, param);
		System.out.println(wxResult);

		WXSessionModel model = JsonUtils.jsonToPojo(wxResult, WXSessionModel.class);

		// 存入session到redis
		redis.set("user-redis-session:" + model.getOpenid(),
				model.getSession_key(),
				1000 * 60 * 30);
		return JsonResult.ok();
	}

	@GetMapping("/wxLogin2")
	public JsonResult wxLogin2(String code) {
		System.out.println("wxlogin - code: " + code);
		return JsonResult.ok();
	}



}
