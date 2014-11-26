/*
 */
package fi.jamk.productlister;

import java.io.File;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Antti Minkkinen
 */
@Controller
public class FileUploadController {
	
	/**
	 * A method for testing the file uploading.
	 * @return HTML page as string for uploading
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public @ResponseBody
	String provideUploadInfo() {
		return "<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<body>\n"
				+ "	<form method=\"POST\" enctype=\"multipart/form-data\"\n"
				+ "		action=\"/upload\">\n"
				+ "		File to upload: <input type=\"file\" name=\"file\"><br /> Name: <input\n"
				+ "			type=\"text\" name=\"name\"><br /> <br /> <input type=\"submit\"\n"
				+ "			value=\"Upload\"> Press here to upload the file!\n"
				+ "	</form>\n"
				+ "</body>\n"
				+ "</html>";
	}
	
	/**
	 * Processes image uploads to the server.
	 * @param name
	 * @param file
	 * @return JSON
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody
	HashMap<String, Object> handleFileUpload(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {

		HashMap<String, Object> result = new HashMap<String, Object>();
		if (!file.isEmpty()) {
			// TODO more checks, if file exists, if file is too big, if file is an image etc...
			try {
				if (!file.getContentType().equals("image/jpeg")) {
					throw new Exception("Wrong content type.");
				}
				
				file.transferTo(new File("/var/www/html/img/" + file.getOriginalFilename()));
				result.put("success", "1");
			} catch (Exception e) {
				result.put("success", "0");
				result.put("message", "You failed to upload " + name + " => " + e.getMessage());
			}
		} else {
			result.put("success", "0");
			result.put("message", "You failed to upload " + name + " because the file was empty.");
		}

		return result;
	}

}
