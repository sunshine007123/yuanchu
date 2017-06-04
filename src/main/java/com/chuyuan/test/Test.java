package com.chuyuan.test;

public class Test {

	public static void main(String[] args) {
		String a = "abcdefg<img src=\"0001.jpg\"/>hijklmnopq<img src=\"0001.jpg\"/>";
		String reg = "<img[^>]*>";
		a = a.replaceAll(reg, "替换标签");
		System.out.println(a);

	}

}
//public class Kyo
//{
//    public static void main(String[] args)
//    {
//        String a = "abcdefg<img src=\"0001.jpg\"/>hijklmnopq";
//        String reg = "<img[^>]*>";
//        a = a.replaceAll(reg, "替换标签");
//        System.out.println(a);
//    }
//}