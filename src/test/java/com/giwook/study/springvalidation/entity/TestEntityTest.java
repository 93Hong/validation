package com.giwook.study.springvalidation.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author 93Hong on 2019-08-17
 *
 */
class TestEntityTest {

	@DisplayName("java bean spec")
	@Test
	void test_javaBean() {
		final int age = 10;

		TestEntity testEntity = new TestEntity();
		testEntity.setAge(age);

		assertThat(testEntity).isNotNull();
		assertThat(testEntity.getAge()).isEqualTo(age);
	}

	@DisplayName("builder")
	@Test
	void test_builder() {
		TestEntity testEntity = TestEntity.builder().build();
		assertThat(testEntity).isNotNull();
	}

}