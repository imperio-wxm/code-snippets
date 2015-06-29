/**
 * [ajax description]
 * @js ajax 基础模版
 * @author  wxmimperio
 */
function ajax(url,fnSucc,fnFaild) {
    //创建ajax请求（非IE6）
    //浏览器兼容问题
    if(window.XMLHttpRequest) {
        var oAjax=new XMLHttpRequest();
    } else {
        var oAjax=new ActiveXObject("Microsoft.XMLHTTP");
    }
    //连接服务器
    //open(方法，文件名，异步传输)
    //消除缓存，加时间戳
    oAjax.open('get',url,true);

    //发送请求
    oAjax.send();

    //接收返回
    oAjax.onreadystatechange=function() {
        //浏览器和服务器进行到哪一步了
        //0:(未初始化)还没有调用open()方法
        //1.(载入)已经调用send()方法，正在请求发送
        //2.(载入完成)send()方法完成，已经收到的响应内容
        //3.(解析)正在解析响应内容
        //4.(完成)响应内容解析完成，可以在客户端使用了
        if(oAjax.readyState==4) {
            //读取成功（失败404）
            if(oAjax.status==200) {
                //返回读取内容
                fnSucc(oAjax.responseText);
            }else {
                if(fnFaild) {
                    //错误信息返回
                    fnFaild(oAjax.status);
                }
            }
        }
    };
}