
public class Card {
	private String type;
	private double multiplier;
	private int securityCode;
	private int cardNumber;
	private Date expirationDate;
	private String company;

	public String getType() {
		return this.type;
	}

	public double getMultiplier() {
		return this.multiplier;
	}

	public int getSecurityCode() {
		return this.securityCode;
	}

	public int getCardNumber() {
		return this.cardNumber;
	}

	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public String getCompany() {
		return this.company;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setMultiplier(double multiplier) {
		this.multiplier = multiplier;
	}

	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public  Card() {
		// TODO should be implemented
	}
}
