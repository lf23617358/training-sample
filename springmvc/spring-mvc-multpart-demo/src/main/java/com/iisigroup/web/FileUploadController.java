package com.iisigroup.web;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	@PostMapping("form")
	public String handleFormUpload(@RequestParam("file") MultipartFile file) throws IOException {

		if (!file.isEmpty()) {
			byte[] bytes = file.getBytes();
			System.out.println(bytes.length);
			// store the bytes somewhere
			return "redirect:uploadSuccess";
		}

		return "redirect:uploadFailure";
	}

	@GetMapping("uploadSuccess")
	public String uploadSuccess(Model model) throws IOException {
		model.addAttribute("result", "uploadSuccess");
		return "fileUpload";
	}
}