/**
 * 
 */
package com.bitshammer.infra.logger;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;



/**
 * @author bruno.martins
 *
 */
public class LoggerProducer {
	
	
	@Produces
	public Logger produceLogger(InjectionPoint p){
		return Logger.getLogger(p.getClass().getCanonicalName());
		
	}

}
