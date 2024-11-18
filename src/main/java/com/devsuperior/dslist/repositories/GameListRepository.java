package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{ //parâmetros: entidade e o tipo do elemento id da entidade utilizada para acessar o banco
	@Modifying
	@Query(nativeQuery = true, 
	value = "UPDATE tb_belonging SET position = :newPosition WHERE game_list_id = :gameListId AND game_id = :gameId")
	void updateBelongingPosition(Long gameListId, Long gameId, Integer newPosition);
}
