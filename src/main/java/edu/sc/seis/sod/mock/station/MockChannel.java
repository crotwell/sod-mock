package edu.sc.seis.sod.mock.station;

import edu.sc.seis.sod.model.common.Location;
import edu.sc.seis.sod.model.common.Orientation;
import edu.sc.seis.sod.model.common.SamplingImpl;
import edu.sc.seis.sod.model.common.TimeInterval;
import edu.sc.seis.sod.model.common.UnitImpl;
import edu.sc.seis.sod.model.station.ChannelGroup;
import edu.sc.seis.sod.model.station.ChannelId;
import edu.sc.seis.sod.model.station.ChannelImpl;
import edu.sc.seis.sod.model.station.SiteImpl;
import edu.sc.seis.sod.model.station.StationImpl;

public class MockChannel {
    
    public static ChannelImpl createChannel() {
        return createChannel(MockChannelId.createVerticalChanId(),
                             "Vertical Channel",
                             MockSite.createSite(),
                             VERTICAL);
    }

    public static ChannelImpl createNorthChannel() {
        return createChannel(MockChannelId.createNorthChanId(),
                             "North Channel",
                             MockSite.createSite(),
                             NORTH);
    }

    public static ChannelImpl createEastChannel() {
        return createChannel(MockChannelId.createEastChanId(),
                             "East Channel",
                             MockSite.createSite(),
                             EAST);
    }

    public static ChannelImpl createOtherSiteSameStationChan() {
        return createChannel(MockChannelId.createOtherSiteSameStationChanId(),
                             "Other Site Same Station Vertical Channel",
                             MockSite.createOtherSiteSameStation(),
                             VERTICAL);
    }

    public static ChannelImpl createOtherNetChan() {
        return createChannel(MockChannelId.createOtherNetChanId(),
                             "Other Net Vertical Channel",
                             MockSite.createOtherSite(),
                             VERTICAL);
    }

    public static ChannelImpl[] createChannelsAtLocs(Location[] locs) {
        ChannelImpl[] chans = new ChannelImpl[locs.length];
        for(int i = 0; i < chans.length; i++) {
            chans[i] = createChannel(locs[i]);
        }
        return chans;
    }

    public static ChannelImpl createChannel(Location location) {
        return createChannel( MockSite.createSite(location));
    }

    public static ChannelImpl createChannel(SiteImpl site) {
        return createChannel(MockChannelId.createChanId("BHZ", site),
                             "fake chan",
                             site,
                             VERTICAL);
    }
    
    public static ChannelImpl createChannel(StationImpl station) {
        return createChannel(station, "00", "BHZ");
    }
    
    public static ChannelImpl createChannel(StationImpl station, String siteCode, String chanCode) {
        SiteImpl s = MockSite.createSite(station, siteCode);
        Orientation o = VERTICAL;
        if (chanCode.endsWith("N")) {
            o = NORTH;
        } else if (chanCode.endsWith("E")) {
            o = EAST;
        }
        return createChannel(MockChannelId.createChanId(chanCode, s),
                             "fake chan",
                             s,
                             o);
    }
    
    public static ChannelImpl createChannelWithId(ChannelId chanId) {
        Orientation o;
        if (chanId.channel_code.endsWith("Z")) {
            o = VERTICAL;
        } else if (chanId.channel_code.endsWith("N")) {
            o = NORTH;
        } else if (chanId.channel_code.endsWith("E")) {
            o = EAST;
        } else {
            o = VERTICAL;
        }
        return createChannel(chanId, "", MockSite.createSite(MockStation.createStation(), chanId.site_code), o);
    }

    private static ChannelImpl createChannel(ChannelId id,
                                         String info,
                                         SiteImpl s,
                                         Orientation o) {
        return new ChannelImpl(id,
                               info,
                               o,
                               new SamplingImpl(20,
                                                new TimeInterval(1.0,
                                                                 UnitImpl.SECOND)),
                               s.getEffectiveTime(),
                               s);
    }

    public static ChannelImpl[] createMotionVector() {
        return createMotionVector(MockStation.createStation());
    }

    public static ChannelImpl[] createMotionVector(StationImpl station) {
        ChannelImpl[] channels = new ChannelImpl[3];
        SiteImpl s = MockSite.createSite(station);
        String[] codes = {"BHZ", "BHN", "BHE"};
        for(int i = 0; i < codes.length; i++) {
            channels[i] = createChannel(MockChannelId.createChanId(codes[i], s),
                                        "Motion Vector Channel " + codes[i],
                                        s,
                                        ORIENTATIONS[i]);
        }
        return channels;
    }

    public static ChannelGroup createGroup() {
        return new ChannelGroup( createMotionVector());
    }
    
    private static final Orientation VERTICAL = new Orientation(0, -90);

    private static final Orientation EAST = new Orientation(90, 0);

    private static final Orientation NORTH = new Orientation(0, 0);

    private static final Orientation[] ORIENTATIONS = {VERTICAL, NORTH, EAST};

}
