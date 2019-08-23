package com.xinpi.controller;

import com.xinpi.service.SysCaptchaService;
import com.xinpi.util.R;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * 类 名 称：LoginController
 * 类 描 述：TODO
 * 创建时间：2019-08-02 17:53
 * 创 建 人：renhao
 */
@Controller
@Api(value = "用户登陆接口")
public class LoginController {
    @Autowired
    private SysCaptchaService sysCaptchaService;

    /**
     * 验证码
     */
    @ApiOperation(value = "验证码", notes = "获取验证码")
    @GetMapping("captcha")
    public void captcha(HttpServletResponse response,String Uuid)throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        //获取图片验证码
        BufferedImage image = sysCaptchaService.getCaptcha(Uuid);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    @GetMapping("/login")
    @ApiIgnore
    public String login() {
        return "login";
    }

    /**
     * 执行登陆
     * */
    @PostMapping("/login")
    @ResponseBody
    @ApiOperation(value = "登陆", notes = "执行登陆")
    public R login(@RequestBody Map<String, Object> params) {
//        验证码
        boolean captcha = sysCaptchaService.validate(params.get("Uuid").toString(), params.get("captcha").toString());
        if(!captcha){
            return R.error("验证码不正确");
        }
        Map user = (Map) params.get("user");
        if (user.get("iphone").equals(null)||user.get("password").equals(null)){
          return   R.error(400,"请输入用户名和密码");
        }
        // 密码MD5加密
        UsernamePasswordToken token = new UsernamePasswordToken(user.get("iphone").toString(), user.get("password").toString(),params.get("state").toString());
        // 获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return R.ok();
        } catch (UnknownAccountException e) {
            return R.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return R.error("账号密码不匹配");
        } catch (LockedAccountException e) {
            return R.error("用户被锁定");
        } catch (AuthenticationException e) {
            return R.error("认证失败");
        }

    }

    @RequestMapping("/")
    @ApiIgnore
    public String redirectIndex() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    @ApiIgnore
    public String index(Model model) {
        // 登录成后，即可通过Subject获取登录的用户信息
        String principal = (String) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", principal);
        return "index";
    }
}
