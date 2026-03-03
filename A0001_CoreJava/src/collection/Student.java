package collection;

public class Student implements Comparable<Student>{   //Add unimplemented methods
	
	int id;
	String name;
	String email;
	public Student(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public void display() {
		System.out.println(id+" "+name+" "+email);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	//40 20 28 10  - Sorting 
	@Override
	public int compareTo(Student o) {
		
		int currentId = o.id;   //40
		int newId = this.id;   //20
		int i = 0;   //initialize
		
		if (newId>currentId) {
			i = 1;
		}
		else if (newId<currentId) {
			i = -1;
		}
		else {
			i = 0;
		}
		return i;
	}
	
	

}
