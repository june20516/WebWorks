package com.bit.juniver.model.service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {
	
	public void fileUpload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String realFolder = request.getSession().getServletContext().getRealPath("/resources/photoUpload/");
		
		UUID uuid = UUID.randomUUID();
				
		String org_filename = file.getOriginalFilename();
		String str_filename = uuid.toString() + org_filename;
		
		System.out.println("원본 파일명 : " + org_filename);
		System.out.println("저장할 파일명 : " + str_filename);
		
		String filepath = realFolder  + str_filename;
		System.out.println("파일경로 : " + filepath);
		
		File f = new File(filepath);
		if (!f.exists()) {
			f.mkdirs();
		}
		
		file.transferTo(f);
		out.println("/resources/photoUpload/"+ str_filename);
		out.close();

	}
}
