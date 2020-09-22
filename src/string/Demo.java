package string;

public class Demo {
	
	public static void main(String[] args) {
		String s1 = "1";
		String s2 = "1";
		System.out.println(s1);
		System.out.println(s2);
		
		String s3 = new String("1");
		System.out.println(s3);
		s3.concat("3");
		System.out.println(s3);
		System.out.println(s1 == s3);
	}
}
