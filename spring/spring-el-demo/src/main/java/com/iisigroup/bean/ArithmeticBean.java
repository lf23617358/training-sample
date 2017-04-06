package com.iisigroup.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ArithmeticBean {
	@Value("#{19 + 1}") // Will inject 20
	private int add;

	@Value("#{'String1 ' + 'String2'}") // Will inject "String1 string2"
	private String addString;

	@Value("#{20 - 1}") // Will inject 19
	private int subtract;

	@Value("#{10 * 2}") // Will inject 20
	private int multiply;

	@Value("#{36 / 2}") // Will inject 19
	private double divide;

	@Value("#{36 div 2}") // Will inject 18, the same as for / operator
	private double divideAlphabetic;

	@Value("#{37 % 10}") // Will inject 7
	private int modulo;

	@Value("#{37 mod 10}") // Will inject 7, the same as for % operator
	private int moduloAlphabetic;

	@Value("#{2 ^ 9}") // Will inject 512
	private int powerOf;

	@Value("#{(2 + 2) * 2 + 9}") // Will inject 17
	private int brackets;

	public int getAdd() {
		return add;
	}

	public void setAdd(int add) {
		this.add = add;
	}

	public String getAddString() {
		return addString;
	}

	public void setAddString(String addString) {
		this.addString = addString;
	}

	public int getSubtract() {
		return subtract;
	}

	public void setSubtract(int subtract) {
		this.subtract = subtract;
	}

	public int getMultiply() {
		return multiply;
	}

	public void setMultiply(int multiply) {
		this.multiply = multiply;
	}

	public double getDivide() {
		return divide;
	}

	public void setDivide(double divide) {
		this.divide = divide;
	}

	public double getDivideAlphabetic() {
		return divideAlphabetic;
	}

	public void setDivideAlphabetic(double divideAlphabetic) {
		this.divideAlphabetic = divideAlphabetic;
	}

	public int getModulo() {
		return modulo;
	}

	public void setModulo(int modulo) {
		this.modulo = modulo;
	}

	public int getModuloAlphabetic() {
		return moduloAlphabetic;
	}

	public void setModuloAlphabetic(int moduloAlphabetic) {
		this.moduloAlphabetic = moduloAlphabetic;
	}

	public int getPowerOf() {
		return powerOf;
	}

	public void setPowerOf(int powerOf) {
		this.powerOf = powerOf;
	}

	public int getBrackets() {
		return brackets;
	}

	public void setBrackets(int brackets) {
		this.brackets = brackets;
	}

}
