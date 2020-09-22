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

	public static <T> boolean safeEqual(T object1, T object2) {
		if (isNullObject(object1) && isNullObject(object2))
			return true;
		if (!isNullObject(object1) && !isNullObject(object2)) {
			return object1.equals(object2);
		}

		return false;
	}
}
