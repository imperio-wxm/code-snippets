package jetty.utils;

import com.wxmimperio.jetty.utils.FolderUtil;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by weiximing.imperio on 2016/7/14.
 */
public class FolderUtilTest {

    @Test
    public void getPathTest() {
        String path = FolderUtil.getLogPath();
        System.out.println("path=" + path);
    }

    @Test
    public void timeTest() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse("2016-06-25 15:19:24");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sdfTxt = new SimpleDateFormat("yyyyMMddHHmmss");
        String timeStemp = sdfTxt.format(date);
        System.out.println(timeStemp);
    }
}
