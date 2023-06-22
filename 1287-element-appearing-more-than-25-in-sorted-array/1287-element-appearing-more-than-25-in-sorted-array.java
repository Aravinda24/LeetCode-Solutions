class Solution {
    public int findSpecialInteger(int[] arr) {

		int length = arr.length;

		int countForRequiredPercentage = (int)(length * 0.25 );
		int count = 0;
		int dummy;

		for (int i = 0; i < length; i++) {

			dummy = arr[i];
			for (int j = i; j < length; j++) {

				if (dummy == arr[j]) {

					count += 1;

					if (count > countForRequiredPercentage) {
						return dummy;
					}
				}

			}
			count = 0;

		}
		return count;
	}
}