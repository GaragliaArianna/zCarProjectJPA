package com.betacom.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="colori")
public class Colore{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idColore;
	
	@Column (
			name="colore"
			)
    private String colore;

}