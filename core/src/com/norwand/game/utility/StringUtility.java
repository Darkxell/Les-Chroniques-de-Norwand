package com.norwand.game.utility;

public class StringUtility {

    /** returns a string containing only the numbers in the given string. */
    public static String getNumbers(String s) {
	String toreturn = "";
	for (int i = 0; i < s.length(); i++) {
	    switch (s.charAt(i)) {
	    case '0':
		toreturn += "0";
		break;
	    case '1':
		toreturn += "1";
		break;
	    case '2':
		toreturn += "2";
		break;
	    case '3':
		toreturn += "3";
		break;
	    case '4':
		toreturn += "4";
		break;
	    case '5':
		toreturn += "5";
		break;
	    case '6':
		toreturn += "6";
		break;
	    case '7':
		toreturn += "7";
		break;
	    case '8':
		toreturn += "8";
		break;
	    case '9':
		toreturn += "9";
		break;
	    }
	}
	return toreturn;
    }

    /**
     * Returns a string that is a substring of this string. The substring begins
     * at the specified {@code beginIndex} and extends to the character at index
     * {@code endIndex - 1}. Thus the length of the substring is
     * {@code endIndex-beginIndex}.
     * <p>
     * 
     * </blockquote>
     * 
     * @from MAC This sample code comes from the MAC java virtual machine, since
     *       String.substring(int,int) doesn't do the same thing on mac and on
     *       windows...
     * @param beginIndex
     *            the beginning index, inclusive.
     * @param endIndex
     *            the ending index, exclusive.
     * @return the specified substring.
     * @exception IndexOutOfBoundsException
     *                if the {@code beginIndex} is negative, or {@code endIndex}
     *                is larger than the length of this {@code String} object,
     *                or {@code beginIndex} is larger than {@code endIndex}.
     */
    public static String substring(String source, int beginIndex, int endIndex) {
	if (beginIndex < 0)
	    throw new StringIndexOutOfBoundsException(beginIndex);
	if (endIndex > source.length())
	    throw new StringIndexOutOfBoundsException(endIndex);
	int subLen = endIndex - beginIndex;
	if (subLen < 0)
	    throw new StringIndexOutOfBoundsException(subLen);
	String toreturn = "";
	for (int i = beginIndex; i < endIndex; ++i)
	    toreturn += source.charAt(i);
	return toreturn;
    }
}
