package jetty.main;

import com.wxmimperio.jetty.pojo.Page;
import com.wxmimperio.jetty.utils.HttpClientUtil;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
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
        param.put("endLine", "20");

        String jsonStr = HttpClientUtil.doPost("http://localhost:8099/fileServlet", param);
        JSONObject jsonObject = JSONObject.fromObject(jsonStr);

        Page page = (Page) JSONObject.toBean(jsonObject, Page.class);

        System.out.println("filename=" + page.getFilename());
        System.out.println("startLine=" + page.getStartLine());
        System.out.println("endLine=" + page.getEndLine());
        System.out.println("size=" + page.getTotalLine());
        List<String> contentList = page.getContent();

        if (page.getContent() != null && page.getContent().size() != 0) {
            for (String line : contentList) {
                System.out.println(line);
            }
        } else {
            System.out.println("文件" + page.getFilename() + "不存在或者内容为空");
        }
    }
}
