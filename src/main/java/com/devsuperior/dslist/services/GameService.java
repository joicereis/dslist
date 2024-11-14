package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMininoDTO;
import com.devsuperior.dslist.repositories.GameRepository;


@Service //Annotation que registra a classe GameService como componente do sistema para ser gerenciado pelo Spring
public class GameService {
	
	@Autowired  //Annotation para injetar a camada de repositório à camada de serviço
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true) //Annotation que garante a transação ACID com banco de dados sem travar o banco para escrita já que é apenas leitura
	public List<GameMininoDTO> findAll(){
		var result = gameRepository.findAll(); //método que busca todos os dados do banco
		List<GameMininoDTO> dto = result.stream().map(x -> new GameMininoDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true) //O reandOnly = true permite que o a transação ocorra mais rápido por não travar o banco para escrita
	public GameDTO findById(Long id) {
		var result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}
}
