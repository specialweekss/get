package org.example.get.Controller;

import org.example.get.Format.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

@RestController
public class LoginController {
    final String appid="wx349741abc39550a4";
    final String secret = "af320bf88ff4de7bff0f169a9d543d3a";
    @GetMapping("/getOpenId")
    public Result getOpenId(String jsCode) throws IOException {
        String url_str = "https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+jsCode+"&grant_type=authorization_code";
        URL url = new URL(url_str);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        StringBuffer sb = new StringBuffer();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        conn.disconnect();
        String openid ="{"+ sb.toString().split(",")[1];
        return Result.success(openid);
    }
}
