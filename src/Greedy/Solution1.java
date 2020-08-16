package Greedy;
//题目六：重构字符串
//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
//
//若可行，输出任意可行的结果。若不可行，返回空字符串。
//
//示例 1:
//
//输入: S = "aab"
//输出: "aba"
//示例 2:
//
//输入: S = "aaab"
//输出: ""
//注意:
//
//S 只包含小写字母并且长度在[1, 500]区间内。
//
//算法分析
//
//给定一个字符串，挪动给定的字符串中字符的位置，使得返回的字符串需要相邻的两个字符不能相同。
//
//思路：
//
//首先将给定的字符串按照字符存储在一个int的数组中，数组的下标为字符串中字符-‘a’，所以该数组将相同的字符的个数存储在数组中。
//利用maxLength获得数组中元素最大的值，即字符串中重复出现的字符最多的字符个数，如果该个数 * 2 - 1大于字符串的长度，就说明相同的字符太多，其他字符已经不能将相同字符分割开
//将字符串中的字符按照奇数偶数放在新建的char数组中。将相同的字符个数小于字符串长度的一半的字符放在奇数下标位置，否则放在偶数下标位置。注意这里需要判断奇数位置是否大于字符串长度
//算法设计
public class Solution1 {

    public String reorganizeString(String S) {
        int[] arr = new int[26];
        int lenght = S.length();
        if(S.length() == 1) return S;
        char[] ret = new char[lenght];
        int maxLength = 0;
        for(char a: S.toCharArray()) {
            if(maxLength < ++arr[a - 'a'])
                maxLength = arr[a - 'a'];
        }
        if(maxLength * 2 - 1 > S.length())
            return "";
        int odd = 0, even = 1;
        for(int i = 0; i < 26; i++) {

            while(arr[i] > 0 && arr[i] < lenght / 2 + 1 && even < lenght) {
                ret[even] = (char)(i + 'a');
                arr[i] --;
                even += 2;
            }
            while(arr[i] > 0) {
                ret[odd] = (char)(i + 'a');
                arr[i] --;
                odd += 2;
            }
        }

        return new String(ret);

    }
}
