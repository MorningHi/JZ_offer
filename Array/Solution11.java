/**
面试题11：旋转数组的最小数字
*/


public class Solution11 {
	// 使用二分法将时间复杂度降低到 O(logN)
    public int minNumberInRotateArray(int [] array) {
        int left = 0, right = array.length - 1;
        int mid;
        while(left < right){
            mid = left + (right - left) / 2;
            if(array[mid] < array[right]){  // 此时最小元素肯定位于[left, mid]
				right = mid;
			}
            else if(array[mid] > array[right]){  // 此时最小元素位于(mid, right]
                left = mid + 1;
            }
            else{  
				// 考虑到如果数组存在重复元素，那么array[mid] == array[right]时
				// 无法判断array[mid]位于哪一部分，则将right前移进而继续判断
                right--;
            }
        }
        return array[left];
    }
}