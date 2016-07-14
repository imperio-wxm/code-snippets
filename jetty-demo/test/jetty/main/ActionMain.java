package jetty.main;

import com.wxmimperio.jetty.utils.HttpClientUtil;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by weiximing.imperio on 2016/7/14.
 */
public class ActionMain {
    @Test
    public void actionTest() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("id", "001");
        param.put("username", "wxmimperio");
        param.put("age", "24");
        param.put("gender", "ÄÐ");

        String jsonStr = HttpClientUtil.doPost("http://localhost:8099/userServlet", param);
        JSONObject jsonObject = JSONObject.fromObject(jsonStr);

        Object username = jsonObject.get("username");
        Object age = jsonObject.get("age");
        Object gender = jsonObject.get("gender");
        Object id = jsonObject.get("id");

        System.out.println(username.toString() + " " + age.toString() + " " + gender.toString() + "" + id.toString());
    }
}
