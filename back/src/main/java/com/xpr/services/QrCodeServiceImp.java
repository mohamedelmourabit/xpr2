package com.xpr.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

public class QrCodeServiceImp implements QrCodeService {
	
	// Encoding charset
    private final static String charset = "UTF-8";
    
    private  static String path="QrCodes/qr";

	@Override
	public String createQrCode(String id) throws WriterException, IOException {
		path = path +"_"+id+".png";
		BitMatrix matrix = new MultiFormatWriter().encode(
	            new String(id.getBytes(charset), charset),
	            BarcodeFormat.QR_CODE, 50, 50);
	 
	        MatrixToImageWriter.writeToFile(
	            matrix,
	            path.substring(path.lastIndexOf('.') + 1),
	            new File(path));
			return path.toString();
	}

	@Override
	public String readQrCode(String path) throws FileNotFoundException, IOException, NotFoundException {
		BinaryBitmap binaryBitmap
        = new BinaryBitmap(new HybridBinarizer(
            new BufferedImageLuminanceSource(
                ImageIO.read(
                    new FileInputStream(path)))));

    Result result
        = new MultiFormatReader().decode(binaryBitmap);

    return result.getText();
	}

}
