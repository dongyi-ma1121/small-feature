package cn.dy.test;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;


public class TestDemo {

	public static void main(String[] args) throws IOException {
		/*内容：键盘录入多名学生的信息；  格式：姓名 语文成绩 数学成绩 英语成绩(中间空格)
		 * 按总分由高到低，将学生的信息进行排列写到文件中
		 * 
		 * 思路：
		 * 1，使用键盘录入技术
		 * 2，操作学生信息，信息很多，需要将信息封装成学生对象
		 * 3，总分由高到低，需要排序，需要对学生对象中的总分排序，那么就需要将多个学生对象进行容器的存储。
		 * 		TreeSet集合
		 * 4，将容器中的学生对象信息写入到指定文件中
		 * */
		/*
		 * 创建一个逆序的比较器
		 */
		Comparator<Students> temp = Collections.reverseOrder();
		/*
		 * 使用操作学生信息的工具类
		 */
		Set<Students> set = GetInfoTool.getStudents(temp);
		File destFile = new File("students.txt");
		GetInfoTool.write2File(set, destFile);

	}

}
