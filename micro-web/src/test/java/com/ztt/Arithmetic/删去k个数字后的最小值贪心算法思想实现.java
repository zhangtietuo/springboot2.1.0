package com.ztt.Arithmetic;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2021/2/1 17:24 45321
 */
public class 删去k个数字后的最小值贪心算法思想实现 {

    public static String removeKDigits(String num,int k){
        //新整数的最终长度=原整数长度-k
        int newLength=num.length()-k;
        //创建一个字符数组（模拟栈），用于接受所有的数字
        char[] stack=new char[num.length()];
        int top=0;
        for (int i = 0; i < num.length(); i++) {
            //遍历当前数字
            char c=num.charAt(i);
            //当栈顶元素大于遍历到的当前数字时，栈顶数字出栈（这里将top--，下次再将数字压入栈时，直接覆盖原有数字）
            while (top>0&&stack[top-1]>c&&k>0){
                top-=1;
                k-=1;
            }
            //遍历到的当前数字入栈
            stack[top++]=c;
        }
        //找到栈中第1个非零数字的位置，以此构建新的整数字符串
        int offset=0;
        while (offset<newLength&&stack[offset]=='0'){
            offset++;
        }
        return offset==newLength?"0":new String(stack,offset,newLength-offset);
    }

    public static void main(String[] args) {
        System.out.println(removeKDigits1("54321", 2));
    }


    public static String removeKDigits1(String num,int k){
        int newLength = num.length() - k;
        char[] a = new char[num.length()];
        int top = 0;
        for(int i=0;i<num.length();i++) {
            char b = num.charAt(i);
            while(top>0&& a[top-1]>b &&k>0) {
                top--;
                k--;
            }
            a[top++] = b;
        }
        return a.toString();
    }
}
