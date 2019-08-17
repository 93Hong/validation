package com.giwook.study.springvalidation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author 93Hong on 2019-08-17
 *
 */
@Data
@NoArgsConstructor @AllArgsConstructor
public abstract class ParentEntity {

	@NotNull
	private Boolean hasCar;
	@Size(min = 1)
	private String carName;

}
