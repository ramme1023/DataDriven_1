package excelData;

import java.io.IOException;
import org.apache.logging.log4j.*;

public class Trail1 {
	static Logger log = LogManager.getLogger();
	
	static ExcelDataCaptureTest ecd = new ExcelDataCaptureTest();
	
	public static void main(String [] args) throws IOException {
		ecd.TestCaseData("tc2");
		System.out.println(ecd.getData("Password"));
		
		log.info("text");
		log.debug("Debug message");
		log.error("Error messgae");
		log.fatal("Fatal messgae");
	}
}
