package relationaldbs;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.Level;
/*cuando ejecutas setlevel(level.off) no te aparece nada en la consola*/
/*cuando ejecutas setlevel(level.All) te aparece toda la informacion  en la consola como el trace, debug, etc...*/	
/*cuando ejecutas setlevel(level.Trace) te aparece toda la informacion  en la consola como el trace, debug, etc...*/
/*cuando ejecutas setlevel(level.All) te aparece  informacion disponible para debug en la consola como el Info, debug, Warn y error.*/
/*cuando ejecutas setlevel(level.warn) te aparece toda la informacion disponible de warn  en la consola como el warn y error.*/
/*cuando ejecutas setlevel(level.error) te aparece solo la informacion disponible para error  en la consola solo te va a aparecer error.*/

public class logingtest {
	static Logger logger = (Logger) LoggerFactory.getLogger(logingtest.class);

	public static void main(String[] args) {
		//logger.setLevel(Level.ERROR);
		division(23, 0);

	}

	private static void division(int i, int j) {
		// TODO Auto-generated method stub
		logger.trace("trace log: You have entered the method 'division'");
		logger.debug("debug log: we use this level of log to debug our program");
		logger.info("info log: this is used to show normal information that happens in our program");
		logger.warn("warn log: used to show potential");
		try {
			int result = i / j;
			logger.trace("result = " + result);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("error log: used for loging problems and error that concern");

		}

	}
}
