package jetty.utils;

import com.wxmimperio.jetty.utils.PropertyUtil;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Test
    public void filterFilesTest() {
        File dir = new File("E:/file_test/");
        FileFilter fileFilter = new RegexFileFilter("^12399243.*.txt");
        File[] files = dir.listFiles(fileFilter);
        List list = new ArrayList();

        for (int i = 0; i < files.length; i++) {
            list.add(files[i].getName().split("\\.")[1]);
        }
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println();
        System.out.println(list.get(list.size()-1));
    }
}
