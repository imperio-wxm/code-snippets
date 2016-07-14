package jetty.utils;

import com.wxmimperio.jetty.utils.PropertyUtil;
import org.junit.Test;

/**
 * Created by weiximing.imperio on 2016/7/14.
 */
public class PropertyUtilTest {

    @Test
    public void getPropertiesTest() {
        String port = PropertyUtil.getInstance().getProperty("jetty.local.port");
        String path = PropertyUtil.getInstance().getProperty("local.log.path");

        System.out.println("port=" + port);
        System.out.println("path=" + path);
    }
}
