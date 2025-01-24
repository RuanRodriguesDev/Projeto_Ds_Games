package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.services.GameService;

public class GameController {
    @Autowired
    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameMinDto>findAll(){
        List<GameMinDto>result = gameService.findAll();
        return result;
    }
    
    
}
