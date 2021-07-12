package com.audit.export.App;

import com.audit.export.App.business.GenerateExcelFile;
import com.audit.export.App.business.GeneratePDFFile;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) throws IOException {
		GeneratePDFFile generatePDFFile = new GeneratePDFFile();
		generatePDFFile.generatePDFFile();
	}

}
