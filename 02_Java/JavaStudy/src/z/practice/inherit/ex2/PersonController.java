package z.practice.inherit.ex2;

import z.practice.oop.ex6.Member;

public class PersonController {
	
	private Student[] s = new Student[3];
	private Employee[] e= new Employee[10];
	
	public int[] presonCount() {
		int[] personCount = new int[2];
		for(Student st : s) {
			if(st == null) {
				break;
			}
			personCount[0]++;
		}
		
		for(Employee em : e) {
			if(em == null) {
				break;
			}
			personCount[1]++;
		}
		return personCount;
	}
	
	public void insertStudent(String name, int age, double height, double weight, int grade, String major) {
		for (int i = 0; i < s.length; i++) {
			if (s[i] == null) { //빈공간 체크
				s[i] = new Student(name, age, height, weight, grade, major);//학생 추가
				return;
			}
		}
	}
	
	
	public Student[] printStudent() {
		return s;
	}

	
	public void insertEmployee(String name, int age, double height, double weight, int salary, String dept) {
		for (int i = 0; i < e.length; i++) {
			if (e[i] == null) { //빈공간 체크
				e[i] = new Employee(name, age, height, weight, salary, dept);//학생 추가
				return;
			}
		}
	}
	
	public Employee[] printEmploye() {
		return e;
	}
	
}
