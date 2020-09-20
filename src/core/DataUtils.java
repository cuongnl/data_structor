package core;

import java.lang.reflect.Field;

public class DataUtils<T extends Comparable<T>> {

	public static <T> boolean isNullObject(T object) {
		if (object == null) {
			return true;
		}
		return false;
	}

	public static <T> boolean isNullOrEmptyObject(T object) {
		if (isNullObject(object)) {
			return true;
		}

		Field[] fields = object.getClass().getDeclaredFields();
		if (isNullObject(fields)) {
			return true;
		}
		for (Field field : fields) {
			Class classOfObject = field.getType();

		}

		return false;

	}
}
