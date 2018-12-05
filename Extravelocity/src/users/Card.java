package users;

import java.io.Serializable;

public class Card implements Serializable{
	private String type;
	private double bankMultiplier;
	private String securityCode;
	private String cardNumber;
	private String expirationDate;
	private String bank;

	// pre: nothing
	// post: initializes the object
	public Card() {
		this.type = null;
		this.bankMultiplier = 0;
		this.securityCode = null;
		this.cardNumber = null;
		this.expirationDate = null;
		this.bank = null;
	}
	
	// pre: parameters corresponding to the fields
	// post: initializes the objects with the given fields as parameters
	public Card(String type, String bank, String securityCode, String cardNumber, String expirationDate) {
		this.type = type;
		this.bank = bank;
		this.securityCode = securityCode;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
	}
	
	// pre: nothing
	// post: returns type
	public String getType() {
		return this.type;
	}

	// pre: nothing
	// post: returns bankMultiplier
	public double getBankMultiplier() {
		return this.bankMultiplier;
	}

	// pre: nothing
	// post: returns securityCode
	public String getSecurityCode() {
		return this.securityCode;
	}

	// pre: nothing
	// post: returns cardNumber
	public String getCardNumber() {
		return this.cardNumber;
	}

	// pre: nothing
	// post: returns ExpirationDate
	public String getExpirationDate() {
		return this.expirationDate;
	}

	// pre: nothing
	// post: returns bank
	public String getBank() {
		return this.bank;
	}

	// pre: a String type
	// post: sets the field type to the parameter type
	public void setType(String type) {
		this.type = type;
	}

	// pre: a double multiplier
	// post: sets the field multiplier 
	public void setBankMultiplier(double multiplier) {
		this.bankMultiplier = multiplier;
	}

	// pre: a String securityCode
	// post: sets the field securityCode to the parameter securitiyCode
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	// pre: a String cardNumber
	// post: sets the field cardNumber to the parameter cardNumber
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	// pre: a String expirationDate
	// post: sets the field expirationDate to the parameter expirationDate
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	// pre: a String bank
	// post: sets the field bank to the parameter bank
	public void setBank(String bank) {
		this.bank = bank;
	}

	
	
}
