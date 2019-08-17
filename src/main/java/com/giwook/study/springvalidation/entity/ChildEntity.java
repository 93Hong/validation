package com.giwook.study.springvalidation.entity;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author 93Hong on 2019-08-17
 *
 */
@Data @EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class ChildEntity extends ParentEntity {

	@NotBlank
	private String name;
	@Min(value = 10)
	private int age;

	@Builder
	public ChildEntity(Boolean hasCar, String carName, String name, int age) {
		super(hasCar, carName);
		this.name = name;
		this.age = age;
	}
}