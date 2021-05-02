package com.xpr.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;

public interface QrCodeService {
	
	public String createQrCode(String id) throws UnsupportedEncodingException, WriterException, IOException;
	
	public String readQrCode(String path) throws FileNotFoundException, IOException, NotFoundException;

}
