package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_belonging")
public class Belonging {
	
	@EmbeddedId 
	private BelongingPK id = new BelongingPK();
	private Integer position;
	
	public Belonging() {
	}

//O construtor receberá os dois atributos da classe BelongingPK e irá setar um por vez no atributo id da classe Belonging, mas poderia já receber o BelongingPK id
	public Belonging(Game game, GameList gameList, Integer position) {
		id.setGame(game);
		id.setGameList(gameList);
		this.position = position;
	}

	public BelongingPK getId() {
		return id;
	}

	public void setId(BelongingPK id) {
		this.id = id;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Belonging other = (Belonging) obj;
		return Objects.equals(id, other.id);
	}
}