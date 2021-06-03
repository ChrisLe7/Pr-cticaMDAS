package es.uco.mdas.tests;

public class TestValueOfEnum {

	public static void main(String[] args) {
		
		TestEnum[] enums = TestEnum.values();
		
		for (TestEnum test : enums) {
			System.out.println(test.getLabel());
		}
		
		for (TestEnum test : enums) {
			System.out.println(test.getValue());
		}
		
	}
	
}
