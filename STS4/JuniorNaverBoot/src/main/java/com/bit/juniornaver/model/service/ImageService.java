package com.bit.juniornaver.model.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

	public void fileUpload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException;
}
