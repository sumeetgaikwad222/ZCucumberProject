package practice_package;

public interface Contant_Interfface {
	
	String Baseurl = "https://demoqa.com/text-box";
	//FMCG creds
	String FMCGemail = "neha.agarwal@freshbite.in";
	String FMCGpassword = "12345Su@";
	String FMCGdashboard = "https://nutra-menu.in1.apiqcloud.com/fmcg/dashboard";
	
	//FBO creds
	String FBOemail = "sumeetgaikwad222@gmail.com";
	String FBOpassword = "12345Su@";
	String FBOdashboard = "https://nutra-menu.in1.apiqcloud.com/fbo/dashboard";
	
	//Drivers paths
	String ChromeDriverPath = "C:\\Users\\SUMEET GAIKWAD\\Drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
	String MSEDGEDriverPath = "C:\\Users\\SUMEET GAIKWAD\\Drivers\\edgedriver_win64\\edgedriver_win64\\msedge.exe";
	String ChromDriverKey = "webdriver.chrome.driver";
	String MSEDGEKey = "webdriver.edge.driver";
	
	//Excel Data
	String ValidExcelFile = "./data/ValidExcelSheet.xlsx.xlsx";
	String Validsheet = "Validdata";
	String InvalidSheet = "Invaliddata";
	
	//Config path
	String Config = "./data/config.properties";
	
	//Waits
	 int IMPLICIT_WAIT = 30;
	 int EXPLICIT_WAIT = 20; 
	 int PAGE_LOAD_TIMEOUT = 60;
	 int SCRIPT_TIMEOUT = 30;
	 
	 //Invalid creds
	 String Invalidemail = "abcd@gmail.com";
	 String Invaludpassword = "123400Su@";
	 String ScreenShot = "C:\\Users\\SUMEET GAIKWAD\\eclipse-workspace\\practiceproject\\data\\Screenshot";

	 
	 String firstname = "sumeet";
	 String lastname = "gaikwad";
	 String username = "sumeetgaikwad";
	 String password = "12345Su@";
	 String email = "sumeet@gmail.com";
	 String currentaddress = "123 Main Street\r\n"
	 		+ "Anytown, NY 12345\r\n"
	 		+ "USA";
	 String permanantaddress = "456 Oak Avenue\r\n"
	 		+ "Floor 2, Suite 200\r\n"
	 		+ "Springfield, IL 62704\r\n"
	 		+ "USA";
}
