package pairmatching.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static final String FUNCTION_MENUS = "123Q";
	public static final String MENU_DELIMITER = "";// 1. 변수까지 합해서 ctrl+alt+c로 상수로 빼기
	public static final String FUNCTION_MENU_DELIMITER = ",";

	public static String getInput() {
		return Console.readLine();
	}

	public static String getFunctionMenu() {
		try {
			String inputValue = InputView.getInput();
			checkFunctionMenuValidation(inputValue);
			return inputValue.trim();
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return getFunctionMenu();
		}
	}

	private static void checkFunctionMenuValidation(String inputValue) {
		checkNullOrEmpty(inputValue);
		checkValidLengthOfFunctionMenu(inputValue);
		checkIsContainedFunctionMenu(inputValue);
	}

	private static void checkNullOrEmpty(String inputValue) {
		if (inputValue == null || inputValue.trim().isEmpty()) {
			throw new IllegalArgumentException("빈칸 입력은 허용하지 않는다.");
		}
	}

	private static void checkValidLengthOfFunctionMenu(String inputValue) {
		int inputValueLength = inputValue.length();
		if (!(1 == inputValueLength)) {
			throw new IllegalArgumentException(1 + "글자만 입력하세요.");
		}
		;
	}

	private static void checkIsContainedFunctionMenu(String inputValue) {
		if (!(Arrays.asList(FUNCTION_MENUS.split(MENU_DELIMITER)).contains(inputValue))) {
			throw new IllegalArgumentException("포함되지 않는 메뉴입니다.");
		}
	}

	public static List<String> getMatchingInfo() {
		try {
			String inputValue = InputView.getInput();
			inputValue = removeSpace(inputValue);
			checkMatchingInfoValidation(inputValue, FUNCTION_MENU_DELIMITER); // split은 체크할때마다 매번 한다.
			return Arrays.asList(inputValue.split(FUNCTION_MENU_DELIMITER));
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return InputView.getMatchingInfo();
		}
	}

	private static String removeSpace(String inputValue) {
		return inputValue.replaceAll(" ", "");
	}

	private static void checkMatchingInfoValidation(String inputValue, String delimeter) {
		checkNullOrEmpty(inputValue);
		checkValidFirstValue(inputValue, delimeter);
		checkValidCountOfMatchingInfo(inputValue, delimeter);
		//TODO 각 단어가 isContains되는지 검사
	}

	private static void checkIncludeInternalSpace(String inputValue) {
		if (inputValue.trim().contains(" ")) {
			throw new IllegalArgumentException("내부에 공백이 포함될 수 없습니다.");
		}
	}

	private static void checkValidFirstValue(String inputValue, String delimeter) {
		if (inputValue.charAt(0) == delimeter.charAt(0)) {
			throw new IllegalArgumentException("정상적인 이름을 입력하세요.");
		}
	}

	private static void checkValidCountOfMatchingInfo(String inputValue, String delimeter) {
		if (!(inputValue.split(delimeter).length == 3)) {
			throw new IllegalArgumentException("3개의 정보를 모두 입력하세요.");
		}
	}

}
