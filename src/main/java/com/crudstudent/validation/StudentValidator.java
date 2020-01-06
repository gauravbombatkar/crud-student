package com.crudstudent.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import java.util.regex.Pattern;
import com.crudstudent.model.Student;

/**
 * @author Gaurav Bombatkar
 */

@Component
public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required");
		ValidationUtils.rejectIfEmpty(errors, "email", "email.required");
		ValidationUtils.rejectIfEmpty(errors, "age", "age.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "city.required");
		Student student = (Student) target;

		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		if (!(pattern.matcher(student.getEmail()).matches())) {
			errors.rejectValue("email", "student.email.invalid");
		}
	}
}