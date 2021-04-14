package test.response;

import java.util.List;

import test.entity.Person;

public class PersonResponse {
	
	public static final int CODE_FAILED = 0;
	public static final int CODE_SUCCESS = 1;
	
	private int code;
	private String message;
	private List<Person> personList;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Person> getPersonList() {
		return personList;
	}
	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}
}
