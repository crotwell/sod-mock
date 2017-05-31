package edu.sc.seis.sod.mock.event;

import edu.sc.seis.sod.mock.MockLocation;
import edu.sc.seis.sod.mock.MockParameterRef;
import edu.sc.seis.sod.model.common.Location;
import edu.sc.seis.sod.model.common.MicroSecondDate;
import edu.sc.seis.sod.model.common.MicroSecondTimeRange;
import edu.sc.seis.sod.model.common.TimeInterval;
import edu.sc.seis.sod.model.common.UnitImpl;
import edu.sc.seis.sod.model.event.CacheEvent;
import edu.sc.seis.sod.model.event.EventAttrImpl;
import edu.sc.seis.sod.model.event.Magnitude;
import edu.sc.seis.sod.model.event.OriginImpl;

public class MockEventAccessOperations {

    public synchronized static CacheEvent[] createEvents() {
        return new CacheEvent[] {createEvent(), createFallEvent()};
    }

    public static CacheEvent createEvent() {
        return createEvent(MockOrigin.create(), MockEventAttr.create());
    }

    public static CacheEvent createEvent(MicroSecondDate time, float lat, float lon) {
        return createEvent(MockOrigin.create(time, lat, lon), MockEventAttr.create());
    }

    public static CacheEvent createFallEvent() {
        return createEvent(MockOrigin.createWallFallOrigin(),
                           MockEventAttr.createWallFallAttr());
    }

    public static CacheEvent createEvent(MicroSecondDate eventTime,
                                         int magnitudeAndDepth,
                                         int feRegion) {
        Magnitude[] mags = {new Magnitude("test", magnitudeAndDepth, "another")};
        return createEvent(MockOrigin.create(eventTime, mags),
                           MockEventAttr.create(feRegion));
    }

    public static CacheEvent createEvent(OriginImpl origin, EventAttrImpl attr) {
        OriginImpl[] origins = {origin};
        return new CacheEvent(attr, origins, origins[0]);
    }

    /**
     * @return 18 events evenly spaced in time from the 1st of January 2001 to
     *         the 31st of that month and evenly spaced over the entire globe
     */
    public static CacheEvent[] createEventTimeRange() {
        MicroSecondDate t = new MicroSecondDate("20010101T000000.000Z");
        MicroSecondTimeRange tr = new MicroSecondTimeRange(new MicroSecondDate(t),
                                                           new TimeInterval(30,
                                                                            UnitImpl.DAY));
        return createEvents(tr, 3, 6);
    }

    public static CacheEvent[] createEvents(MicroSecondTimeRange timeRange,
                                            int rows,
                                            int cols) {
        int numEvents = rows * cols;
        TimeInterval timeBetweenEvents = (TimeInterval)timeRange.getInterval()
                .divideBy(numEvents);
        CacheEvent[] events = new CacheEvent[numEvents];
        Location[] locs = MockLocation.create(rows, cols);
        Magnitude[][] mags = MockMagnitude.getMagnitudes(4.0f, 10.0f, numEvents);
        for(int i = 0; i < numEvents; i++) {
            MicroSecondDate eventBegin = timeRange.getBeginTime()
                    .add((TimeInterval)timeBetweenEvents.multiplyBy(i));
            OriginImpl o = new OriginImpl("Mock Event " + i,
                                      "Mockalog",
                                      "Charlie Groves",
                                      eventBegin,
                                      locs[i],
                                      mags[i],
                                      MockParameterRef.createParams());
            EventAttrImpl ea = MockEventAttr.create();
            events[i] = new CacheEvent(ea, o);
        }
        return events;
    }
}
