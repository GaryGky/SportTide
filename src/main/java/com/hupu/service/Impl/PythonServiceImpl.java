package com.hupu.service.Impl;

import com.hupu.service.PythonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service("pythonService")
@Transactional
public class PythonServiceImpl implements PythonService {
    
    private String python_executor(String cmd) {
        try {
            Process proc = Runtime.getRuntime().exec(cmd);
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(), "GBK"));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            int re = proc.waitFor();
            if (re == 0) {
                return "success";
            } else {
                return "fail: there is something wrong in python scripts";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    
    @Override
    public String predictGames() {
        String predict_cmd = "/root/prediction/predict.sh";
        return python_executor(predict_cmd);
    }
    
    @Override
    public String crawlGames(String dates) {
        String crawl_cmd = "/root/spider/crawl.sh -u " + dates;
        return python_executor(crawl_cmd);
    }
}
