package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.repositories.GameListRepository;


@Service //Annotation que registra a classe GameService como componente do sistema para ser gerenciado pelo Spring
public class GameListService {
	
	@Autowired  //Annotation para injetar a camada de repositório à camada de serviço
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true) //Annotation que garante a transação ACID com banco de dados sem travar o banco para escrita já que é apenas leitura
	public List<GameListDTO> findAll(){
		var result = gameListRepository.findAll(); //método que busca todos os dados do banco
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	}
}
