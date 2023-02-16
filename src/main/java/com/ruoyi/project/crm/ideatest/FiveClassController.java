package com.ruoyi.project.crm.ideatest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.crypto.Cipher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.util.Random;
/**
 * <p> 五类-弱随机/弱加密/弱哈希/硬编码/Cookie未设置Secure  </p>
 */
@Controller
public class FiveClassController {

    /**
     * <p> 弱随机数  </p>
     * <p> java.util.Random.nextInt(int) </p>
     * @return
     */

    @RequestMapping("/Randomn")
    @ResponseBody
    public int Random(HttpServletRequest request) {
        return new Random().nextInt(Integer.parseInt(request.getParameter("a")));
    }
    /**
     * <p> 五类-弱加密  </p>
     * <p> javax.crypto.Cipher.getInstance(java.lang.String) </p>
     */
    @RequestMapping("/Cipher")
    @ResponseBody
    public String Cipher(HttpServletRequest request) {
        String cipher = request.getParameter("a");
        try {
            return Cipher.getInstance(cipher).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * <p> 五类-弱哈希  </p>
     * <p> javax.crypto.MessageDigest.getInstance(java.lang.String) </p>
     */
    @RequestMapping("/MessageDigest")
    @ResponseBody
    public String MessageDigest(HttpServletRequest request) {
        try {
            return MessageDigest.getInstance(request.getParameter("a")).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * <p> 五类-Cookie未设置secure  </p>
     * <p> javax.servlet.http.Cookie.setSecure(boolean) </p>
     */
    @RequestMapping("/Cookie")
    @ResponseBody
    public String Cookie(HttpServletRequest request) {
        Cookie cookie = new Cookie("lang", "lang");
        cookie.setSecure(false);
        return null;
    }
}
