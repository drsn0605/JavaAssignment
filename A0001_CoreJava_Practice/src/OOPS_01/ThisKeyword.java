package OOPS_01;

class Student{
	int id;   //instance variable
	String name;  //instance variable 	
	
	Student(int id,String name){
		this.id = id;   //this.id refers to instance variable & id refers to local variable(parameter).
		//assigns 101 to instance variable id
		
		this.name = name;   //this.name refers to instance variable & name refers to local variable.
		//assigns Darshan to instance variable name
	
	}
	
	void display() {
		System.out.println(id+ " "+name);
	}
}

public class ThisKeyword {
	public static void main(String[] args) {
		Student s1 = new Student(101,"Darshan");
		s1.display();
	}

}

//Inside the constructor:

//local id = 101

//local name = "Darshan"

//this.id = id; → assigns 101 to the object’s instance variable

//this.name = name; → assigns "Darshan" to the object’s instance variable

//So:
//👉 Local variables: id, name (inside constructor parameters)

//👉 Instance variables: id, name (declared at the top of the class)

