package com.surely.surely.utils;

import java.util.List;
import java.util.Optional;

public class ValidationUtils {

	public static <T> T optionalIsEmpty(Optional<T> optional, String errorMessage) {
		return optional.orElseThrow(() -> new CodedException(errorMessage));
	}

	public static <T> List<T> listIsEmpty(List<T> list, String errorMessage) {
		if (list.isEmpty())
			throw new CodedException(errorMessage);
		return list;
	}

}
