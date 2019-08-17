package com.giwook.study.springvalidation.controller;

import com.giwook.study.springvalidation.entity.ChildEntity;
import com.giwook.study.springvalidation.entity.TestEntity;
import com.giwook.study.springvalidation.validator.ChildValidator;
import com.giwook.study.springvalidation.validator.OtherValidator;
import com.giwook.study.springvalidation.validator.ParentValidator;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 *
 * @author 93Hong on 2019-08-17
 *
 */
@RestController
public class ValidationTestController {

	private final ChildValidator childValidator;
	private final ParentValidator parentValidator;
	private final OtherValidator otherValidator;

	public ValidationTestController(ChildValidator childValidator, ParentValidator parentValidator, OtherValidator otherValidator) {
		this.childValidator = childValidator;
		this.parentValidator = parentValidator;
		this.otherValidator = otherValidator;
	}

	@PostMapping(value = "/test", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity test(@RequestBody @Valid ChildEntity childEntity, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(childEntity);
	}

	@PostMapping(value = "/other", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity other(@RequestBody @Valid TestEntity testEntity, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(testEntity);
	}

	@InitBinder(value = "childEntity")
	public void initChildValidator(WebDataBinder dataBinder) {
		dataBinder.addValidators(parentValidator, childValidator);
	}

	@InitBinder(value = "testEntity")
	public void initTestValidator(WebDataBinder dataBinder) {
		dataBinder.addValidators(parentValidator, otherValidator);
	}

}
