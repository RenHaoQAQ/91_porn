package com.xinpi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 类 名 称：ViewController
 * 类 描 述：所有的视图解析
 * 创建时间：2019-08-07 16:59
 * 创 建 人：renhao
 */
@Controller
@ApiIgnore
public class ViewController {
    /*
    关于我们
    */
    @GetMapping("about.html")
    public String showAbout() {
        return "about";
    }

    /*
   博客
   */
    @GetMapping("blog.html")
    public String showBlog() {
        return "blog";
    }

    /*
   视屏
   */
    @GetMapping("portfolio.html")
    public String showPortfolio() {
        return "portfolio";
    }

    /*
  主页
  */
    @GetMapping("index.html")
    public String showIndex() {
        return "index";
    }

    /*
     * 联系我们*/
    @GetMapping("contact.html")
    public String showContact() {
        return "contact";
    }
    /*
    * 文件上传*/
    @GetMapping("upload.html")
    public String showUpload() {
        return "upload";
    }


}
