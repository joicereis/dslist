package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;

public class GameMininoDTO {
	private Long id;
	private String title;
	private Integer year; 
	private String imgUrl;
	private String shortDescription;
	
	public GameMininoDTO() {
		
	}

	public GameMininoDTO(Game entity) {
		id = entity.getId(); //busca o id da entitidade Game e salva no id do DTO
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	
}
