public class Currency {
    private String code;
    private String name;

    public Currency(String code, String name) {
        this.code = code;
        this.name = name;

	}

	// Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public Object getCurrency_name() {
		return null;
	}

	public Object getCurrency_code() {
		return null;
	}
}