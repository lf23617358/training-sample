package com.iisigroup.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RegexBean {
	@Value("#{'100' matches '\\d+' }") // Will inject true
	private boolean validNumeric;

	@Value("#{'100fghdjf' matches '\\d+' }") // Will inject false
	private boolean invalidNumeric;

	@Value("#{'valid alphabetic string' matches '[a-zA-Z\\s]+' }") // Will
																	// inject
																	// true
	private boolean validAlphabetic;

	@Value("#{'invalid alphabetic string #$1' matches '[a-zA-Z\\s]+' }") // Will
																			// inject
																			// false
	private boolean invalidAlphabetic;

	public boolean isValidNumeric() {
		return validNumeric;
	}

	public void setValidNumeric(boolean validNumeric) {
		this.validNumeric = validNumeric;
	}

	public boolean isInvalidNumeric() {
		return invalidNumeric;
	}

	public void setInvalidNumeric(boolean invalidNumeric) {
		this.invalidNumeric = invalidNumeric;
	}

	public boolean isValidAlphabetic() {
		return validAlphabetic;
	}

	public void setValidAlphabetic(boolean validAlphabetic) {
		this.validAlphabetic = validAlphabetic;
	}

	public boolean isInvalidAlphabetic() {
		return invalidAlphabetic;
	}

	public void setInvalidAlphabetic(boolean invalidAlphabetic) {
		this.invalidAlphabetic = invalidAlphabetic;
	}

}
