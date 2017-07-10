
package java08面向对象多态;
/*
 * 类文件被封装进对象
 * d1.class()//获取class文件
 * class文件里有构造函数和一般方法
 * 注意有的功能的复写  比如返回对象字符串值（哈希值）
 * 
 */
/*内部类：
 * 
 * 访问规则：
 * 	1.内部类可以直接访问外部类中的成员，包括私有
 *   之所以可以直接访问外部类中的成员，是因为内部类中持有一个外部类的引用 格式 外部类名。this。
 *  2.外部类想要访问内部类可以直接创建内部对象
 *  
 * 访问格式：
 * 1. 当内部类在外部类的成员位置上时，而且菲私有，可以在外部其他类中直接建立内部类对象
 *  格式：
 *  	外部类名。内部类名  变量 = 外部类对象（）。内部类对象（）；
 *   	Outer.Inner in =new Outer().new Inner();
 *  2.当内部类在成员位置上就可以被成员修饰符所修饰
 *     private ：将内部类在外部类中进行封装
 *     static： 内部类就具备static的特性
 *     当内部类被静态修饰后 只能直接访问外部类中的static成员。出现访问局限。 
 *     定义时为共享数据
 *     当内部类中定义了静态成员 该内部类必须是静态
 *     
 *     在外部其他类中如何直接访问静态内部类的非静态成员：：
 *        new Outer.Inner().function(); //function非静态
 *     在外部其他类中，如何直接访问Static内部类的静态成员：
 *        Outer.Inner.function();
 *      
 *      当外部类中的静态方法访问内部类时，内部类也必须是静态的
 *        
 *     
 * */
class Outer
{
	int x;
	 class Inner//内部类直接访问方式   如果不被封装
	{//访问x时不用创建外部对象
		int x = 4;
		 void function()
		{ 
			int x = 6;
			System.out.println("内部类"+x);//x=6
			System.out.println("内部类"+this.x);//4
			System.out.println("内部类"+Outer.this.x);//3
			//外部类的引用
		}
	}
	
	static  class Inner2
	{
		void show()
		{
			System.out.println("inner2 show");
		}
	}
	
	void method()
	{
		
		Inner in =new Inner();
		in.function();
	}
	
	public static void method2()
	{
		//Inner.function(); static class  static function()
		new Inner2().show();
	}
}
public class Object类toString {
	public  static void  main (String[] args)
	{
		Outer.Inner in =new Outer().new Inner();
	}

}











