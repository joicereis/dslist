package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMininoDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;

@RestController //define que é um controlador/controller
@RequestMapping(value = "/lists") //mapeamento de recurso, nesse exemplo o recurso a ser mapeado serão os games.
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService; //injetado o GameService pois o retorno de jogos por lista ocorre no GameService
	
	
	@GetMapping //verbo de get mapeado para esse método de busca de todos os games
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMininoDTO> findByList(@PathVariable Long listId){
		List<GameMininoDTO> result = gameService.findByList(listId);
		return result;
	}
}
