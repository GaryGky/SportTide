package com.hupu.controller;

import com.hupu.pojo.Recap;
import com.hupu.service.Impl.RecapServiceImpl;
import com.hupu.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recap")
public class ReCapController {
    @Autowired
    @Qualifier("recapService")
    private RecapServiceImpl recapService;
    
    
    @RequestMapping("/getRecap")
    public Recap getrecapByGame(int gameId) {
        return recapService.queryById(gameId);
    }
    
    @RequestMapping(value = "/getRecapByDate", method = RequestMethod.GET)
    public List<Recap> getRecapByDate(String foreDate, String backDate) {
        return recapService.getRecapByDay(foreDate, backDate);
    }
}
