package value;

public class UsersValue {
	private String userId;
	private String password;
	private String name;
	private String address;
	
	public UsersValue(String userId, String password, String name, String address) {
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.address = address;
	}

	public UsersValue() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
