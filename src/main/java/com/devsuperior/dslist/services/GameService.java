package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameMinDto>findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDto>dto = result.stream().map(x -> new GameMinDto(x)).toList();
        return dto;
    }
}
