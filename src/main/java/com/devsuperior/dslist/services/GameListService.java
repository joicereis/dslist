package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.projection.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;


@Service //Annotation que registra a classe GameService como componente do sistema para ser gerenciado pelo Spring
public class GameListService {
	
	@Autowired  //Annotation para injetar a camada de repositório à camada de serviço
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true) //Annotation que garante a transação ACID com banco de dados sem travar o banco para escrita já que é apenas leitura
	public List<GameListDTO> findAll(){
		var result = gameListRepository.findAll(); //método que busca todos os dados do banco
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	}
	
	//metodo para movimentar itens em uma lista
	@Transactional
	public void moveList(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId); //listagem de games de acordo com o id da lista
		
		//remoção de um item da lista de acordo com o indice de origem informado(sourceIndex) e atribução à variavel obj
		GameMinProjection obj = list.remove(sourceIndex);
		
		//inserção do valor da variável obj na lista na posição destino(destinationIndex)
		list.add(destinationIndex, obj);
		
		//efetivar alterações em banco de dados
		
		var min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		var max = sourceIndex < destinationIndex ? destinationIndex  : sourceIndex;
		
		//alterando as posições dos jogos no banco de dados dentro do intervalo entre a posição mínima e máxima encontradas
		for(int i = min; i <= max ; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);			
		}
	}
}

