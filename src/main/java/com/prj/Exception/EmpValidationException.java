package com.prj.Exception;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.json.JSONObject;

import com.google.common.collect.Iterables;

public class EmpValidationException implements ExceptionMapper<ConstraintViolationException>{

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        JSONObject jSONObject = new  JSONObject();
        constraintViolations.stream().forEach(data->{
        	 String name = Iterables.getLast(data.getPropertyPath()).getName();
        	 String message = data.getMessage();
        	 jSONObject.put(name,message);
        });
		return null;
	}

}
