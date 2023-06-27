class Solution {
    public int[] sortArray(int[] nums) {

		int inputArrayLength = nums.length;

		if (inputArrayLength < 2) {
			return nums;
		}

		int midSection = inputArrayLength / 2;
		int[] leftArray = new int[midSection];
		int[] rightArray = new int[inputArrayLength - midSection];

		for (int i = 0; i < midSection; i++) {
			leftArray[i] = nums[i];
		}

		for (int i = midSection; i < inputArrayLength; i++) {

			rightArray[i - midSection] = nums[i];
		}

		sortArray(leftArray);
		sortArray(rightArray);
		conquer(nums, leftArray, rightArray);

		return nums;

	}

	public void conquer(int[] inputArray, int[] leftArray, int[] rightArray) {
		int i = 0;
		int j = 0;
		int k = 0;

		while (leftArray.length != i && rightArray.length != j) {

			if (leftArray[i] < rightArray[j]) {
				inputArray[k] = leftArray[i];
				i++;
			}

			else {
				inputArray[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (leftArray.length != i) {
			inputArray[k] = leftArray[i];
			i++;
			k++;
		}

		while (rightArray.length != j) {
			inputArray[k] = rightArray[j];
			j++;
			k++;
		}

		return;
	}
}