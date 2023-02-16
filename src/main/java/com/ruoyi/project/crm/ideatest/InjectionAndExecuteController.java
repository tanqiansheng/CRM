package com.ruoyi.project.crm.ideatest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@Controller
public class InjectionAndExecuteController {
    /**
     * <p> smtp注入 </p>
     * <p> javax.mail.Message.setSubject(java.lang.String) </p>
     */

    /**
     * <p> 命令执行 </p>
     * <p> javax.mail.Message.setSubject(java.lang.String) </p>
     */
    @RequestMapping("/execute")
    @ResponseBody
    public String execute(HttpServletRequest request) throws URISyntaxException {
        try {
            //ping -c1 localhost
            Runtime.getRuntime().exec("ping -n 1 "+request.getParameter("a"));
            System.out.println("6666");
        }catch(IOException e) {
            System.out.println(e);
        }
        return "wwwww";
    }
    /**
     * <p> 服务器端请求伪造 </p>
     * <p> javax.mail.Message.setSubject(java.lang.String) </p>
     */

    /**
     * <p> sql注入 </p>
     * <p> java.sql.Statement.execute(java.lang.String) </p>
     */
    @RequestMapping("/sqlInjection")
    @ResponseBody
    public String sqlInjection(HttpServletRequest request) throws SQLException {
        //a=show tables
        String srr = request.getParameter("a");
        Connection con = DriverManager.getConnection("jdbc:mysql://59.110.230.231:13306/auto_test_app", "root", "123456");
        PreparedStatement ps2= con.prepareStatement(srr);
        ps2.execute();
        con.isClosed();
        return null;
    }
}
