package com.audit.export.App;

import com.audit.export.App.business.GeneratePDF;
import com.audit.export.App.business.TableTest;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) throws IOException {
//		GeneratePDF generatePDF = new GeneratePDF();
//		generatePDF.generateFile();

		TableTest tableTest = new TableTest();
		tableTest.generate();
	}

}
