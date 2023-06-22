class Solution {
    public boolean digitCount(String num) {

		int length = num.length();

		byte zero = 0;
		byte one = 0;
		byte two = 0;
		byte three = 0;
		byte four = 0;
		byte five = 0;
		byte six = 0;
		byte seven = 0;
		byte eight = 0;
		byte nine = 0;

		for (int i = 0; i < length; i++) {

			char temp = num.charAt(i);
			int dummy = ((int) temp) - 48;

			switch (dummy) {
			case 0:
				zero += 1;
				break;
			case 1:
				one += 1;
				break;
			case 2:
				two += 1;
				break;
			case 3:
				three += 1;
				break;
			case 4:
				four += 1;
				break;
			case 5:
				five += 1;
				break;
			case 6:
				six += 1;
				break;
			case 7:
				seven += 1;
				break;
			case 8:
				eight += 1;
				break;
			case 9:
				nine += 1;
				break;

			}

		}

		for (int i = 0; i < length; i++) {

			char temp = num.charAt(i);
			int dummy = ((int) temp) - 48;

			switch (i) {
			case 0:
				if (zero != dummy) {
					return false;
				}
				break;
			case 1:
				if (one != dummy) {
					return false;
				}

				break;
			case 2:
				if (two != dummy) {
					return false;
				}

				break;
			case 3:
				if (three != dummy) {
					return false;
				}

				break;
			case 4:
				if (four != dummy) {
					return false;
				}

				break;
			case 5:
				if (five != dummy) {
					return false;
				}

				break;
			case 6:
				if (six != dummy) {
					return false;
				}

				break;
			case 7:
				if (seven != dummy) {
					return false;
				}

				break;
			case 8:
				if (eight != dummy) {
					return false;
				}

				break;
			case 9:
				if (nine != dummy) {
					return false;
				}

				break;

			}

		}

		return true;

	}
}