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

}
