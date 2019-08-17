package com.giwook.study.springvalidation.validator;

import com.giwook.study.springvalidation.entity.TestEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author 93Hong on 2019-08-17
 *
 */
@Component
public class ChildValidator implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		return TestEntity.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TestEntity testEntity = (TestEntity)target;


	}
}
