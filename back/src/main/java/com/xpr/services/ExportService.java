package com.xpr.services;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ExportService {

	
	
	private final Path rootLocation = Paths.get("upload-dir");

	public String store(MultipartFile file) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			String date = dateFormat.format(new Date()).replace(" ", "-").replace(":", "-");
			String newFileName = file.getOriginalFilename().split("")[0] + date + ".xlsx";
			Files.copy(file.getInputStream(), this.rootLocation.resolve(newFileName));
			return newFileName;
		} catch (Exception e) {
			throw new RuntimeException("FAILed to store new file !" + e.getMessage());
		}
	}


	public Resource loadFile(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}

	

}
