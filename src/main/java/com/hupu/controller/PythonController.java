package com.hupu.controller;

import com.hupu.service.Impl.PythonServiceImpl;
import com.hupu.service.Impl.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/python")
public class PythonController {
    @Autowired
    @Qualifier("pythonService")
    private PythonServiceImpl pythonService;

    @RequestMapping("/predictGames")
    public String predictGames() {
        return pythonService.predictGames();
    }

    @RequestMapping("/crawlGames")
    public String crawlGames(String dates) {
        return pythonService.crawlGames(dates);
    }
}
