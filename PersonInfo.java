package predictagefinal;
public  class PersonInfo {
	String name;
	String state;
	String sex;
	int year;
	int total;
	int occurrence;
	
	

	public PersonInfo( String state, String sex, int year, String name,int total) {
		
	
		this.state = state;
		this.sex = sex;
		this.year = year;
		this.name = name;
		
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "PersonInfo [name=" + name + '\'' + " state=" + state + '\''+ " sex=" + sex + '\'' + " year=" + year + '\'' + " total=" + total
				+ "]";
	}


}