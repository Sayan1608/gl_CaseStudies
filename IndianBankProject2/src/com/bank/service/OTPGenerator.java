package com.bank.service;

import java.util.Random;

public class OTPGenerator {

	public int generateOTP() {
		Random r = new Random();
		return r.nextInt(9999);
	}
}
