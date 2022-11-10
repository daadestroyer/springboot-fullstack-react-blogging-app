package com.daadestroyer.springbootfullstackreactbloggingapp.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String resourceName;
	private String fieldName;
	private long fieldValue;

	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		super(resourceName + " resource not found with " + fieldName + ":" + fieldValue);
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

}
