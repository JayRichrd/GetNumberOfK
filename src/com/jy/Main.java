package com.jy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[] number = new int[] { 1, 2, 3, 3, 3, 3, 4, 5 };
		System.out.println("输入的数组:" + Arrays.toString(number));
		
		System.out.print("请输入k:");
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		scanner.close();
		
		int last = getIndexOfLastK(number, 0, number.length - 1, k);
		int first = getIndexOfFirstK(number, 0, number.length - 1, k);
		
		if (last > -1 && first > -1)
			System.out.println(k + "在数组中出现的次数:" + (last - first + 1));
		else
			System.out.println("数组中不存在" + k);
	}

	/**
	 * 确定数组中一定范围内第一个k的位置
	 * 
	 * @param number
	 *            数组
	 * @param start
	 *            范围开始的位置
	 * @param end
	 *            范围结束的位置
	 * @param k
	 *            确定的数k
	 * @return 如果确定了第一k的位置则返回，否则返回-1
	 */
	public static int getIndexOfFirstK(int[] number, int start, int end, int k) {
		// 数组中的这个范围内没有数k
		if (start > end)
			return -1;
		// 首先获取中间值
		int midIndex = (start + end) >> 1;
		int midData = number[midIndex];
		// 确定k可能出现的范围
		if (midData == k) {
			if ((midIndex > 0 && number[midIndex - 1] != k) || midIndex == 0)
				return midIndex;
			else
				end = midIndex - 1;
		} else if (midData < k)
			start = midIndex + 1;
		else
			end = midIndex - 1;
		// 继续递归确定第一个k的位置
		return getIndexOfFirstK(number, start, end, k);
	}

	/**
	 * 确定数组中一定范围内最后一个k的位置
	 * 
	 * @param number
	 *            数组
	 * @param start
	 *            范围开始的位置
	 * @param end
	 *            范围结束的位置
	 * @param k
	 *            确定的数k
	 * @return 如果确定了最后一个k的位置则返回，否则返回-1
	 */
	public static int getIndexOfLastK(int[] number, int start, int end, int k) {
		// 数组中的这个范围内没有数k
		if (start > end)
			return -1;
		int length = number.length;
		// 首先获取中间值
		int midIndex = (start + end) >> 1;
		int midData = number[midIndex];
		// 确定k可能出现的范围
		if (midData == k) {
			if ((midIndex < length - 1 && number[midIndex + 1] != k) || midIndex == length - 1)
				return midIndex;
			else
				start = midIndex + 1;
		} else if (midData < k)
			start = midIndex + 1;
		else
			end = midIndex - 1;
		// 继续递归确定第一个k的位置
		return getIndexOfLastK(number, start, end, k);
	}

}
