package com.audit.export.App;

import com.audit.export.App.business.GenerateExcelFile;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) throws IOException {
		GenerateExcelFile generateExcelFile = new GenerateExcelFile();
		generateExcelFile.generate();
	}

}
