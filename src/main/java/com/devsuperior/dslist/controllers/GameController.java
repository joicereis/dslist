package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameMininoDTO;
import com.devsuperior.dslist.services.GameService;

@RestController //define que é um controlador/controller
@RequestMapping(value = "/games") //mapeamento de recurso, nesse exemplo o recurso a ser mapeado serão os games.
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping //verbo de get mapeado para esse método de busca de todos os games
	public List<GameMininoDTO> findAll(){
		List<GameMininoDTO> result = gameService.findAll();
		return result;
	}
}
