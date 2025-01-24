package search;

import java.util.Scanner;

public class BinarySearch {

    //基本的二分查找
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // 防止溢出
            if (nums[mid] == target) {
                return mid; // 找到目标，返回索引
            } else if (nums[mid] < target) {
                left = mid + 1; // 调整左边界
            } else {
                right = mid - 1; // 调整右边界
            }
        }
        return -1; // 未找到目标，返回-1
    }

    //查找最后一个小于等于给定值的元素
    public int findLastLessOrEqual(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1; // 数组为空，返回-1
        }

        int left = 0;
        int right = nums.length - 1;
        int result = -1; // 初始化结果为-1，表示未找到

        while (left <= right) {
            int mid = left + (right - left) / 2; // 防止溢出
            if (nums[mid] <= target) {
                result = mid; // 更新结果为当前mid，稍后可能被更大的mid值更新
                left = mid + 1; // 保留右半部分，寻找更大的可能值
            } else {
                right = mid - 1; // 排除当前mid及右半部分
            }
        }

        return result; // 返回最后一个小于等于target的元素索引，如果没有则返回-1
    }

    //查找第一个等于给定值的元素
    public int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1; // 初始化结果为-1，未找到时返回
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) { // 注意这里是>=，因为我们想向左逼近第一个等于target的元素
                right = mid - 1; // 向左逼近
            } else {
                left = mid + 1;
            }
            if (nums[mid] == target) { // 找到等于target的元素，记录索引并继续向左逼近以确认是否为第一个
                result = mid;
            }
        }
        return result;
    }

    //查找最后一个等于给定值的元素
    public int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1; // 初始化结果为-1，未找到时返回
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) { // 注意这里是<=，因为我们想向右逼近最后一个等于target的元素
                left = mid + 1; // 向右逼近
            } else {
                right = mid - 1;
            }
            if (nums[mid] == target) { // 找到等于target的元素，记录索引并继续向右逼近以确认是否为最后一个
                result = mid;
            }
        }
        return result;
    }

    //查找第一个大于等于给定值的元素
    public int findFirstGreaterOrEqual(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) { // 如果中间值小于target，则向右逼近第一个大于等于target的元素
                left = mid + 1;
            } else { // 如果中间值大于等于target，则向左逼近以确认是否为第一个大于等于target的元素或直接返回结果（如果已经是第一个）
                right = mid - 1;
            }
        }
        return left < nums.length ? left : -1; // 如果left越界，则表示没有找到符合条件的元素，返回-1；否则返回left（即为第一个大于等于target的元素的索引）
    }

    public static void main(String[] args) {
       BinarySearch binarySearch = new BinarySearch();
       int[] nums = new int[]{2,5,3,7,9,10,18,101};
       System.out.println(binarySearch.binarySearch(nums,10));
    }

}

