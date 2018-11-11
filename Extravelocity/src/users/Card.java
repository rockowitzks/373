package users;



public class Card {
	private String type;
	private double bankMultiplier;
	private String securityCode;
	private String cardNumber;
	private String expirationDate;
	private String bank;

	public String getType() {
		return this.type;
	}

	public double getBankMultiplier() {
		return this.bankMultiplier;
	}

	public String getSecurityCode() {
		return this.securityCode;
	}

	public String getCardNumber() {
		return this.cardNumber;
	}

	public String getExpirationDate() {
		return this.expirationDate;
	}

	public String getBank() {
		return this.bank;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setBankMultiplier(double multiplier) {
		this.bankMultiplier = multiplier;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public  Card() {
		type = null;
		bankMultiplier = 0;
		securityCode = null;
		cardNumber = null;
		expirationDate = null;
		bank = null;
	}
	
	public Card(String type, double bankMultiplier, String securityCode, String cardNumber, String expirationDate) {
		this.type = type;
		this.bankMultiplier = bankMultiplier;
		this.securityCode = securityCode;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
	}
}
