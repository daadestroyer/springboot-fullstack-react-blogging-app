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
	private long fieldValue1;
	private String fieldValue2;

	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue1) {
		super(resourceName + "  not found with " + fieldName + ":" + fieldValue1);
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue1 = fieldValue1;
	}

	public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue2) {
		super(resourceName + "  not found with " + fieldName + ":" + fieldValue2);
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue2 = fieldValue2;
	}

}
