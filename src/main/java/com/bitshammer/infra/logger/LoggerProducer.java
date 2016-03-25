/**
 * 
 */
package com.bitshammer.infra.logger;

import java.util.logging.Logger;



/**
 * @author bruno.martins
 *
 */
public class LoggerProducer {
	
	
	public static Logger produceLogger(Class<?> clazz){
		return Logger.getLogger(clazz.getCanonicalName());
		
	}

}
