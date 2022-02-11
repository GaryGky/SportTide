package com.hupu.controller;

import com.hupu.dao.TeamDao;
import com.hupu.pojo.FutureGames;
import com.hupu.service.Impl.FutureGamesServiceImpl;
import com.hupu.service.Impl.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/future")
public class FutureGameController {
    @Autowired
    @Qualifier("teamService")
    private TeamServiceImpl teamService;
    @Autowired
    @Qualifier("futureGamesService")
    private FutureGamesServiceImpl futureGamesService;
    
    @RequestMapping("/getGamePreView") // 获得比赛前瞻
    public Map getGamePreView(int gameId) {
        return futureGamesService.getGamePreview(gameId);
    }
    
    @RequestMapping("/getAllFutureGame")
    public List<FutureGames> getAllFutureGame(HttpServletRequest request) {
        if (request.getSession().getAttribute("allFuture") != null) {
            return (List<FutureGames>) request.getSession().getAttribute("allFuture");
        }
        List<FutureGames> list = futureGamesService.queryAllByLimit(0, 200);
        request.getSession().setAttribute("allFuture", list);
        HashMap<String, String> team2Arena = new HashMap<>();
        for (FutureGames games : list) {
            team2Arena.put(games.getGameid(),
                    teamService.queryById(games.getHome()).getHomecourt());
        }
        if (request.getSession().getAttribute("homeCourt") == null) {
            request.getSession().setAttribute("homeCourt", team2Arena);
        }
        return list;
    }
}
