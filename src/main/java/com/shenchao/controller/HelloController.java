package com.shenchao.controller;

import com.shenchao.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;

/**
 * Created by shenchao on 2017/2/3.
 */
@Controller
public class HelloController {
    @RequestMapping("testConvert")
    public void testConvert(@RequestParam User user, Writer w) throws IOException {
        System.out.println(user);
        w.write(user.toString());
    }

    @RequestMapping("testHttpEntity")
    public HttpEntity<byte[]> testHttpEntity(HttpEntity<byte[]> entity) {
        HttpHeaders header = new HttpHeaders();
        header.set("Content-Disposition", "attachment;fileName= a.pdf");
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>("hello".getBytes(), header, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping("testDataTime")
    @ResponseBody
    public String testDataTime(@DateTimeFormat(pattern = "yyyy:MM;dd") Date date) {
        System.out.println(date);
        return "hello";
    }

    @RequestMapping("testHello")
    public String testHello(HttpServletRequest request) {
        System.out.println("hello world");
        return "hello";
    }

    @RequestMapping("testHttpMessageConvert")
    public String testHttpMessageConvert(@RequestBody String body) {
        System.out.println(body);
        return "hello";
    }

    @RequestMapping("testModelAttribute")
    public String testModelAttribute(User user) {
        System.out.println(user);
        return "abc";
    }

//    @ModelAttribute
    public void testModel(@RequestParam(required = false) Integer id, Model model) {
        System.out.println("testModel........"+id);
        model.addAttribute(new User("sc", 1, "男"));
    }

    @RequestMapping("JSESSIONID")
    public String testCookie(@CookieValue(name = "JSESSIONID") String JSESSIONID,Writer writer) {
        System.out.println(JSESSIONID);
        return "abc";
    }

    @RequestMapping("testJsonView")
//    @JsonView(User.WithPasswordView.class)
    @ResponseBody
    public User testJsonView(){
        System.out.println(Thread.currentThread().getName()+"-------------------------1-");
        return new User("沈超", 2, "男","234324");
    }

    @GetMapping("testRequestContextUtils")
    public String testRequestContextUtils(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("sc", "hello");
        return "redirect:testHello";
    }

    @GetMapping("testExecption2")
    public String testException2() {
        if (true)
            throw new RuntimeException("出错了");
        return "hello";
    }

    @GetMapping("testContentNavigation")
    public User testContentNavigation() {
        return new User("沈超", 1, "男", "123456");
    }

}
