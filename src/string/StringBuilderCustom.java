package string;

import java.util.Arrays;

import core.DataUtils;
import interfaces.IString;

public class StringBuilderCustom implements IString {

	private char[] characterBuffer;
	private int curIndex;
	private int DEFAULT_CAPACITY = 10;

	public StringBuilderCustom() {
		characterBuffer = new char[DEFAULT_CAPACITY];
		curIndex = 0;
	}

	@Override
	public void append(String input) {
		if (!DataUtils.isNullObject(input)) {
			char[] charArray = input.toCharArray();
			while (overFlow(charArray.length)) {
				ensureCapacity();
			}
			for (int i = 0; i < charArray.length; i++) {
				characterBuffer[curIndex++] = charArray[i];
			}
		}
	}

	private boolean overFlow(int length) {
		return (length + curIndex) > characterBuffer.length;
	}

	private void ensureCapacity() {
		characterBuffer = Arrays.copyOf(characterBuffer, characterBuffer.length * 2);
	}

	@Override
	public boolean container(String input) {
		if(!DataUtils.isNullObject(input) && !DataUtils.isNullObject(characterBuffer)) {
			for(int index = 0; index < input.length(); index++) {
				if(input.contains(characterBuffer.toString())) {
					
				}
			}
		}
		return false;
	}

	@Override
	public void remove(String input) {
		// TODO Auto-generated method stub

	}

	@Override
	public void replace(String pattern, String input) {
		

	}
	
	public String toString() {
		return new String(characterBuffer, 0, curIndex);
	}
}
