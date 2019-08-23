package com.xinpi.down;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.StreamProgress;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpException;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * 类 名 称：DownFile
 * 类 描 述：TODO
 * 创建时间：2019-08-23 12:50
 * 创 建 人：renhao
 */
@Controller
@RequestMapping("file")
public class DownFileController {
    @Value("${file.upload.path1}")
    private String path1;

    @GetMapping("/down")
    public void getConllection() {
        String fileUrl = "https://vd2.bdstatic.com/mda-jhmse9b50b1m08i6/sc/mda-jhmse9b50b1m08i6.mp4?auth_key=1566538727-0-0-2db5574574005e9b206f94f19b3705b9&bcevod_channel=searchbox_feed&pd=bjh&abtest=all";
        //将文件下载后保存在path1下，返回结果为下载文件大小
        HttpUtil.downloadFile(fileUrl, FileUtil.file(path1));
    }


}
