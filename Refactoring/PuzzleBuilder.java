package Refactoring3;

public class PuzzleBuilder {
	private String[] arrayValue;
	private int[] arrayX;
	private int[] arrayY;
	private int[] arrayDirection;
	private int index;

	private String name;

	public PuzzleBuilder(String name, int size) {
		this.name = name;
		arrayValue = new String[size];
		arrayX = new int[size];
		arrayY = new int[size];
		arrayDirection = new int[size];
		index = 0;
	}

	public int getSize() {
		return index;
	}

	public int addWord(String value, int x, int y, int direction) {
		for (int i = 0; i < index; i++) { // duplicate check
			boolean isSameValue = arrayValue[i].compareTo(value) == 0;
			boolean isSameDirection = arrayDirection[i] == direction;
			if (isSameValue && isSameDirection)
				return -1;
		}
		boolean result = false;
		
		result = checkOverlapWord(value, x, y, direction, result);
		
		if (result) // overlap word
			return -2;

		arrayValue[index] = value; // store word
		arrayX[index] = x;
		arrayY[index] = y;
		arrayDirection[index] = direction;

		index++;
		return 0;
	}

	private boolean checkOverlapWord(String value, int x, int y, int direction, boolean result) {
		for (int i = 0; i < index; i++) {
			if (arrayDirection[i] == 0) { // 가로
				if (direction == 0) { // 가로
					if (arrayY[i] == y && ((x >= arrayX[i] && x <= arrayX[i] + arrayValue[i].length())
							|| (x + value.length() >= arrayX[i] && x + value.length() <= arrayX[i] + arrayValue[i].length()))) {
						result = true;
						break;
					}
				} else { // 세로
					if (x >= arrayX[i] && x <= arrayX[i] + arrayValue[i].length() && arrayY[i] >= y && arrayY[i] <= y + value.length()) {
						result = true;
						break;
					}
				}
			} else { // 세로
				if (direction == 0) { // 가로
					if (arrayX[i] >= x && arrayX[i] <= x + value.length() && y >= arrayY[i] && y <= arrayY[i] + arrayValue[i].length()) {
						result = true;
						break;
					}
				} else { // 세로
					if (arrayX[i] == x && ((y >= arrayY[i] && y <= arrayY[i] + arrayValue[i].length())
							|| (y + value.length() >= arrayY[i] && y + value.length() <= arrayY[i] + arrayValue[i].length()))) {
						result = true;
						break;
					}
				}
			}
		}
		return result;
	}

	public int getWordPosition(int coordinate, String value, int direction) {
		for (int i = 0; i < index; i++) {
			boolean isSameValue = arrayValue[i].compareTo(value) == 0;
			boolean isSameDirection = arrayDirection[i] == direction;
			
			if (isSameValue && isSameDirection) {
				if (coordinate == 0)
					return arrayX[i];
				else
					return arrayY[i];
			}
		}

		return -1;
	}

	public int getPoint() {
		int totalPoint = 0;
		for (int i = 0; i < index; i++) {
			int point = calculatePoint(i);

			totalPoint += point;
		}
		return totalPoint;
	}

	public String getShortReport(boolean isHTML) {
		String value = getReportTitle(isHTML);
		
		int point = 0;
		for (int i = 0; i < index; i++) {
			int result = calculatePoint(i);	
			point += result;

			if (isHTML)
				value += "\tWord: <B>" + arrayValue[i] + "</B>\tPoint: <B> " + result + "</B>\n";
			else
				value += "\tWord: " + arrayValue[i] + "\tPoint: " + result + "\n";
		}
		value = getPointReport(isHTML, value, point);
		return value;
	}

	public String getFullReport(boolean isHTML) {
		String value = getReportTitle(isHTML);
		
		int point = 0;
		for (int i = 0; i < index; i++) {
			int result = calculatePoint(i);
			point += result;

			if (isHTML)
				value += "\tWord: <B>" + arrayValue[i] + "\tPosition: [" + arrayX[i] + ", " + arrayY[i] + "]" + "\tDir: " + arrayDirection[i]
						+ " </B> Point: <B> " + result + "</B>\n";
			else
				value += "\tWord: " + arrayValue[i] + "\tPosition: [" + arrayX[i] + ", " + arrayY[i] + "]" + "\tDir: " + arrayDirection[i]
						+ " Point: " + result + "\n";
		}
		value = getPointReport(isHTML, value, point);
		return value;
	}
	private String getReportTitle(boolean isHTML) {
		String value;
		if (isHTML) {
			value = "<H1> Report on Puzzle <EM> " + name + "</EM></H1>\n";
		} else {
			value = "Report on Puzzle " + name + "\n";
		}
		return value;
	}
	private int calculatePoint(int i) {
		int result;
		if (arrayDirection[i] == 0)
			result = arrayValue[i].length();
		else
			result = arrayValue[i].length() * 2;
		return result;
	}
	private String getPointReport(boolean isHTML, String value, int point) {
		if (isHTML) {
			value += "<HR> Total Point: <B>" + point + "</B><P>\n";
		} else {
			value += "Total Point: " + point + "\n";
		}
		return value;
	}
}

