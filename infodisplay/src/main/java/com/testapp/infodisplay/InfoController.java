package com.testapp.infodisplay;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class InfoController {

    @RequestMapping(value = "{*path}")
    public @ResponseBody
    String getInfo(@RequestHeader Map<String, String> headers,  HttpServletRequest request){

        String info = "";
        String path = request.getServletPath();
        info+="path = " + path + "<br/><br/>";
        for(Map.Entry<String, String> entry : headers.entrySet()){
            info += entry.getKey() + " : " + entry.getValue() + "</br>";
        }
        return info;
    }
}
