package edu.sc.seis.sod.mock;

import java.time.Month;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.TimeZone;

import edu.sc.seis.seisFile.fdsnws.stationxml.BaseNodeType;
import edu.sc.seis.sod.model.common.ISOTime;
import edu.sc.seis.sod.model.common.MicroSecondDate;
import edu.sc.seis.sod.model.common.QuantityImpl;
import edu.sc.seis.sod.model.common.UnitImpl;

public class Defaults{
    
    
    private static Calendar cal = Calendar.getInstance();
    static{
        //the berlin wall fell on the 13th of June, 1990
        cal.set(Calendar.YEAR, 1990);
        cal.set(Calendar.MONTH, Calendar.JUNE);
        cal.set(Calendar.DATE, 13);
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    public static final MicroSecondDate EPOCH = new MicroSecondDate(0);
    
    public static final MicroSecondDate WALL_FALL = new MicroSecondDate(cal.getTime());
    
    public static final ZonedDateTime EPOCH_ZDT =  ZonedDateTime.of(1970, 1, 1, 0, 0, 0, 0, BaseNodeType.TZ_UTC);
    
    public static final ZonedDateTime WALL_FALL_ZDT = ZonedDateTime.of(1990, Month.JUNE.getValue(), 13, 12, 0, 0, 0, BaseNodeType.TZ_UTC);
    
    public static final QuantityImpl ZERO_K = new QuantityImpl(0, UnitImpl.KILOMETER);
    
    public static final QuantityImpl TEN_K = new QuantityImpl(10, UnitImpl.KILOMETER);
}
