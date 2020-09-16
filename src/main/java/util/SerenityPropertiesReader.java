package util;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class SerenityPropertiesReader {

	private static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
	
	public static String getIsExcelInstalled()
	
	{
		return variables.getProperty("isExcelInstalled");
		
	}
}
