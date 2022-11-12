package com.daadestroyer.springbootfullstackreactbloggingapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catId;
	private String catTitle;
	private String catDesc;

}
