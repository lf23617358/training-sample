package com.iisigroup.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LogicalBean {
	@Value("#{250 > 200 && 200 < 4000}") // Will inject true
	private boolean and;

	@Value("#{250 > 200 and 200 < 4000}") // Will inject true
	private boolean andAlphabetic;

	@Value("#{400 > 300 || 150 < 100}") // Will inject true
	private boolean or;

	@Value("#{400 > 300 or 150 < 100}") // Will inject true
	private boolean orAlphabetic;

	@Value("#{!true}") // Will inject false
	private boolean not;

	@Value("#{not true}") // Will inject false
	private boolean notAlphabetic;

	public boolean isAnd() {
		return and;
	}

	public void setAnd(boolean and) {
		this.and = and;
	}

	public boolean isAndAlphabetic() {
		return andAlphabetic;
	}

	public void setAndAlphabetic(boolean andAlphabetic) {
		this.andAlphabetic = andAlphabetic;
	}

	public boolean isOr() {
		return or;
	}

	public void setOr(boolean or) {
		this.or = or;
	}

	public boolean isOrAlphabetic() {
		return orAlphabetic;
	}

	public void setOrAlphabetic(boolean orAlphabetic) {
		this.orAlphabetic = orAlphabetic;
	}

	public boolean isNot() {
		return not;
	}

	public void setNot(boolean not) {
		this.not = not;
	}

	public boolean isNotAlphabetic() {
		return notAlphabetic;
	}

	public void setNotAlphabetic(boolean notAlphabetic) {
		this.notAlphabetic = notAlphabetic;
	}
	
}
