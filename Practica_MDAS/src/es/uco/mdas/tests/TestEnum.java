package es.uco.mdas.tests;

public enum TestEnum {

	Test1("Test 1", 1),
	Test2("Test 2", 2),
	Test3("Test 3", 3);
	
	public String label;
	public int value;
	
	TestEnum(String label, int value) {
		this.label = label;
		this.value = value;
	}
	
	public String getLabel() {
		return label;
	}
	
	public int getValue() {
		return value;
	}
	
}
