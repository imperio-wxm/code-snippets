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

        param.put("id", "12399243");
        param.put("startLine", "0");
        param.put("endLine", "60");

        String jsonStr = HttpClientUtil.doPost("http://localhost:8099/fileServlet", param);
        JSONObject jsonObject = JSONObject.fromObject(jsonStr);

        String filename = jsonObject.get("filename").toString();
        String startLine = jsonObject.get("startLine").toString();
        String endLine = jsonObject.get("endLine").toString();
        String totalLine = jsonObject.get("totalLine").toString();
        String[] content = jsonObject.get("content").toString().split(",");

        System.out.println("filename=" + filename);
        System.out.println("startLine=" + startLine);
        System.out.println("endLine=" + endLine);
        System.out.println("size=" + totalLine);
        for (String line : content) {
            System.out.println(line);
        }
    }
}
