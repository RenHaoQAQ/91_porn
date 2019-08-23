package com.xinpi.controller;

import com.xinpi.util.DateUtils;
import com.xinpi.util.R;
import com.xinpi.util.RRException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * 类 名 称：FileUploadConfig
 * 类 描 述：文件上传统一接口
 * 创建时间：2019-08-19 09:08
 * 创 建 人：renhao
 */
@RestController
@RequestMapping("file")
@Api(value = "文件上传接口")
public class FileUploadController {
    @Value("${file.upload.path1}")
    private String path;

    @PostMapping("upload")
    @ApiOperation(value = "文件上传", notes = "执行文件上传")
    public R doUpload(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new RRException("上传文件不能为空");
            }
            //上传文件(文件后缀)
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            // 文件原名称
            String fileName = file.getOriginalFilename();
            // 按照日期对文件分类
            String format = DateUtils.format(new Date());
            //上传的地址
            String realPath = path + format;
            File file1 = new File(realPath);
            // 自定义的文件名称
            String trueFileName = UUID.randomUUID().toString() + fileName;
            // 判断文件类型是否为空
            if (suffix != null) {
                //线上地址
                if (!file1.exists() && !file1.isDirectory()) {
                    file1.mkdir();
                }
                path = realPath + "/" + trueFileName;
                try {
                    file.transferTo(new File(path));
                } catch (IOException e) {
                    e.printStackTrace();
                    return R.error("文件写入失败");
                }
            } else {
                System.out.println("文件类型为空");
                return R.error(400, "文件类型为空");
            }
            //--上传到自己本机服务器结束
            //保存文件信息
            return R.ok().put("url", "/file/" + format + "/" + trueFileName);
        } catch (MaxUploadSizeExceededException ex) {
            return R.error("上传的文件不能超过10M");
        }
    }
}
