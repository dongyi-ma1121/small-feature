package cn.dy.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class GetInfoTool {
	/**
	 * 获取所有学生对象
	 * 
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	/*
	 * 不带指定比较器，默认自然选择排序
	 */
	public static Set<Students> getStudents() throws IOException{
		return getStudents(null);
	}
	/*
	 *带有指定比较器 
	 */
	public static Set<Students> getStudents(Comparator<Students> comp) throws IOException {
		// 创建集合
		Set<Students> set = null;
		//如果比较器存在，就创建一个带有比较器的集合
		if(comp == null)
			set = new TreeSet<Students>();
		else{
			set = new TreeSet<Students>(comp);}
		System.out.println("请输入学生语数英成绩，数据间留空格，输入over结束");
		// 键盘录入
		BufferedReader bufr = new BufferedReader(new InputStreamReader(
				System.in));
		// 获取键盘录入信息
		String line = null;
		while ((line = bufr.readLine()) != null) {
			//设置键盘录入结束标记
			if("over".equals(line)){
				break;
			}
			// 因为录取的信息是有规律的，可以根据指定的规则对信息进行分割
			String[] str = line.split(" ");
			// 将数组中的信息封装成学生对象
			Students s = new Students(str[0], Integer.parseInt(str[1]),
					Integer.parseInt(str[2]), Integer.parseInt(str[3]));
			// 将学生对象加到集合中
			set.add(s);
		}
		return set;

	}

	/**
	 * 将集合中的学生信息写入到指定的文件中
	 * 
	 * @throws IOException
	 */
	public static void write2File(Set<Students> set, File destfile)
			throws IOException {
		BufferedWriter bufw = null;
		try {
			bufw = new BufferedWriter(new FileWriter(destfile));
			// 遍历集合
			for (Students s : set) {
				bufw.write("姓名：" + s.getName() + "\t语文成绩：" + s.getChinese()
						+ "\t数学成绩：" + s.getMath() + "\t英语成绩：" + s.getEnglish()
						+ "\t总成绩：" + s.getSum());
				bufw.newLine();// 换行
				bufw.flush(); // 刷新缓冲区

			}
		} finally {
			if (bufw != null) {
				try {
					bufw.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
	}
}
