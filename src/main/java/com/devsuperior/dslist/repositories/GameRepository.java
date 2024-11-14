package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{ //parâmetros: entidade e o tipo do elemento id da entidade utilizada para acessar o banco
	
}
