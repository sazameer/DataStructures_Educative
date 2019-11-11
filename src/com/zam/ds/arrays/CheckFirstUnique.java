package com.zam.ds.arrays;

class CheckFirstUnique
{
	public static int findFirstUnique(int[] arr) 
	{
		int result = 0;
		int repeatingArr[] = new int[arr.length];
		// write your code here
		for(int i = 0 ; i < arr.length ; i++){
			boolean isRepeated = false;
			if(repeatingArr[i] == 0 && i < arr.length - 1){
				for(int j = i+1; j < arr.length ; j++) {
					if(arr[i] == arr[j]){
						isRepeated = true;
						repeatingArr[i] = 1;
						repeatingArr[j] = 1;
					}
				}
			}
			if(!isRepeated && repeatingArr[i] != 1) {
				result = arr[i];
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		
		int[] inputArray = {4,5,1,2,0,4};
		int firstUnique = findFirstUnique(inputArray);
		System.out.println("First Unique : " + firstUnique);
	}
}
