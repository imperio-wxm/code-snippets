package com.wxmimperio.jetty.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * Created by weiximing.imperio on 2016/7/14.
 */
public class HttpClientUtil {
    private static Log log = LogFactory.getLog(HttpClientUtil.class);
    private static HttpClient httpClient = new DefaultHttpClient();

    public static String doPost(String url, Map<String, String> param) {
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        StringBuffer urlLog=null;
        try {
            if (MapUtils.isNotEmpty(param)) {
                urlLog=new StringBuffer();
                urlLog.append(url).append("?");
                for (Entry<String, String> entery : param.entrySet()) {
                    nvps.add(new BasicNameValuePair(entery.getKey(), entery.getValue()));
                    urlLog.append(entery.getKey()).append("=").append(entery.getValue()).append("&");
                }

                log.info("#Request URL：" + urlLog);
            }

            httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
            HttpResponse response = httpClient.execute(httpPost);
            int code = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            String jsonStr = EntityUtils.toString(entity);

            log.info("#Response：" + (null != jsonStr && !"".equals(jsonStr) ? jsonStr : code));
            return jsonStr;
        } catch (Exception e) {
            log.error("#Response error：" + url + "出错");
            e.printStackTrace();
            return null;
        } finally {
            httpPost.abort();
        }
    }
}
