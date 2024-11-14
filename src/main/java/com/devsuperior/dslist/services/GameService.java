package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMininoDTO;
import com.devsuperior.dslist.repositories.GameRepository;

@Service //Annotation que registra a classe GameService como componente do sistema para ser gerenciado pelo Spring
public class GameService {
	
	@Autowired  //Annotation para injetar a camada de repositório à camada de serviço
	private GameRepository gameRepository;
	
	public List<GameMininoDTO> findAll(){
		var result = gameRepository.findAll(); //método que busca todos os dados do banco
		List<GameMininoDTO> dto = result.stream().map(x -> new GameMininoDTO(x)).toList();
		return dto;
	}
}
