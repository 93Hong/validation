package com.giwook.study.springvalidation.validator;

import com.giwook.study.springvalidation.entity.ParentEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author 93Hong on 2019-08-17
 *
 */
@Component
public class ParentValidator implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		return ParentEntity.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		ParentEntity parentEntity = (ParentEntity) o;

		if(parentEntity.getHasCar()) {
			if (parentEntity.getCarName() == null || parentEntity.getCarName().isBlank()) {
				errors.rejectValue("carName", "isBlank");
			}
		}

	}
}
