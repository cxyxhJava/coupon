package com.frank.controller.DY;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.jsoup.Jsoup;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 14:52 2020-06-28
 * @ Description：抖音无水印视频下载接口
 * @ Modified By：
 */
//@ApiModel("抖音文件")
//@RestController("/DY/file")
public class DYFileDownloadController {



   // @GetMapping("/download")
    //@ApiOperation(value = "通过抖音链接获取无水印视频", nickname = "dyFileDownload", tags = {"抖音文件"})
//    void dyFileDownload(
//            @ApiParam(value = "抖音视频地址",required = true) @RequestParam(value = "url",required = false) String url, HttpServletResponse response)throws Exception{
//
//        response.setContentType("audio/mp4");
//        response.setHeader("content-disposition", "attachment;filename=" + "VideoEnvironment.mp4");
//        BufferedInputStream in = getView(url);
//        try {
//            int len;
//            byte buffer[] = new byte[1024];
//            OutputStream out = response.getOutputStream();
//            while ((len = in.read(buffer)) > 0) {
//                out.write(buffer, 0, len);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (in != null) {
//                try {
//                    in.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
//    }

    public BufferedInputStream getView(String url) throws Exception{

        //过滤链接，获取http连接地址
        String finalUrl = decodeHttpUrl(url);

        //1.利用Jsoup抓取抖音链接
        //抓取抖音网页
        String htmls = Jsoup.connect(finalUrl).ignoreContentType(true).execute().body();
        //System.out.println(htmls); //做测试时使用

        //2.利用正则匹配可以抖音下载链接
        //playAddr: "https://aweme.snssdk.com/aweme/v1/playwm/?video_id=v0200ffc0000bfil6o4mavffbmroeo80&line=0",
        //具体匹配内容格式：「https://aweme.snssdk.com/aweme/...line=0」
        Pattern patternCompile = Pattern.compile("(?<=playAddr: \")https?://.+(?=\",)");
        //利用Pattern.compile("正则条件").matcher("匹配的字符串对象")方法可以将需要匹配的字段进行匹配封装 返回一个封装了匹配的字符串Matcher对象

        //3.匹配后封装成Matcher对象
        Matcher m = patternCompile.matcher(htmls);

        //4.①利用Matcher中的group方法获取匹配的特定字符串 ②利用String的replace方法替换特定字符,得到抖音的去水印链接
        String matchUrl ="";
        while(m.find()) {
            matchUrl = m.group(0).replaceAll("playwm", "play");
        }

        //5.将链接封装成流
        //注:由于抖音对请求头有限制,只能设置一个伪装手机浏览器请求头才可实现去水印下载
        Map<String, String> headers = new HashMap();
        headers.put("Connection", "keep-alive");
        headers.put("Host", "aweme.snssdk.com");
        headers.put("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 12_1_4 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16D57 Version/12.0 Safari/604.1");

        //6.利用Joup获取视频对象,并作封装成一个输入流对象
        BufferedInputStream in = Jsoup.connect(matchUrl).headers(headers).timeout(10000).ignoreContentType(true).execute().bodyStream();
        //注:打印获取的链接
        System.out.println("-----抖音去水印链接-----\n"+matchUrl);
        return in;
    }

    public static String decodeHttpUrl(String url) {
        int start = url.indexOf("http");
        int end = url.lastIndexOf("/");
        String decodeurl = url.substring(start, end);
        return decodeurl;
    }

    public static void main(String[] args) throws IOException {
        DYFileDownloadController dyFileDownloadController = new DYFileDownloadController();
        dyFileDownloadController.test("https://v.douyin.com/J83AVaY/ ");
    }

    public void test(String url) throws IOException {
        //url = 抖音APP内的分享连接
//        HttpRequest request = HttpRequest.get(url);
//        String res = request.body();
//        String awemeId=TextUtil.getSubString(res, "https://www.iesdouyin.com/share/video/", "/?");
//        url ="https://api-hl.amemv.com/aweme/v1/aweme/detail/?aid=1128&app_name=aweme&version_code=251&aweme_id="+awemeId;
//        request=HttpRequest.get(url).header("User-Agent","Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A372 Safari/604.1");
//        res = request.body();
////这时候我们就会获取到抖音API返回的JSON 下一步解析
//        String title = JsonUtil.getJsonValue(res, "aweme_detail.share_info.share_title");//标题
//        String playAddr = JsonUtil.getJsonValue(res, "aweme_detail.video.play_addr.url_list[0]");//无水印视频链接
//        String cover = JsonUtil.getJsonValue(res, "aweme_detail.video.origin_cover.url_list[0]");//视频封面
//如果您需要其他的数据，请您自己研究API返回的JSON数据


    }


}
