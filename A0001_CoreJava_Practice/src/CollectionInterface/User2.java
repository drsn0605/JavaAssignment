package CollectionInterface;

public class User2 implements Comparable<User2>{
	int id;
	String name;
	String email;
	public User2(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	//10 1 5
	@Override
	public int compareTo(User2 o) {
		int currentId = o.id;
		int newId = this.id;
		int i = 0;
		if(currentId<newId) {
			i = 1;
		}
		else if(currentId>newId) {
			i = -1;
		}
		else {
			i = 0;
		}
		return i;
	}
	
	

}
