public class Student  {

	@Override
	public int hashCode() {
		return age;
		
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			return ((((Student) obj).name == name) && (((Student) obj).age == age) && (((Student) obj).className == className));
		}
		return false;
	}

	String name;
	Integer age;
	String className;

	public Student() {

	}

	public Student(String name, Integer age, String className) {
		super();
		this.name = name;
		this.age = age;
		this.className = className;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	
	
	
}
