package com.betacom.jpa.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="macchina")
public class Macchina extends Veicolo{
	
	@Column (
			name="numero_porte",
			nullable = false
			)
	private Integer numeroPorte;
	
	@Column (
			name="targa",
			nullable = false
			)
	private String targa;
	
	@Column (
			name="cilindrata",
			nullable = false
			)
	private Integer cc;
	

}
