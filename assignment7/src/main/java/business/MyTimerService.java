package business;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Stateless
public class MyTimerService {

	@Resource
	TimerService timerService;
	
	private static Logger logger = Logger.getLogger("business.MyTimerService");
    
	public void setTimer(long interval) {
		timerService.createTimer(interval, "My Timer");
	}
	
    public MyTimerService() {
        // TODO Auto-generated constructor stub
    }
	
	@SuppressWarnings("unused")
	@Schedule(second="*/10", minute="*", hour="0-23", dayOfWeek="Mon-Fri",
      dayOfMonth="*", month="*", year="*", info="MyTimer")
    private void scheduledTimeout(final Timer t) {
        logger.info("@Scheduled Timer triggered at " + new java.util.Date());
    }
	
	@Timeout
	public void programmaticTimeout(Timer timer) {
		logger.info("@Timeout in programmatic timer at " + new java.util.Date());
	}
}