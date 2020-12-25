package com.example.bootmq.bootmq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Description： TODO
 * <p>
 * Author: miangong
 * <p>
 * Date: Created in 2020/12/25 13:32
 */
@Controller
public class MqController {

    @Autowired
    private ProductMq productMq;

    @Autowired
    private Consumer consumer;

    @RequestMapping(path = "mq/test", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject cproQuerySkuImage(HttpServletRequest request,
                                        @RequestParam(value = "param", required = true) String param) throws Exception {
        productMq.send();
        return new JSONObject();
    }
}
