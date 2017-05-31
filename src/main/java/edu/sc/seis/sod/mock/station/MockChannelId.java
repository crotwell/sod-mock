package edu.sc.seis.sod.mock.station;

import edu.sc.seis.sod.model.common.MicroSecondDate;
import edu.sc.seis.sod.model.station.ChannelId;
import edu.sc.seis.sod.model.station.SiteImpl;

public class MockChannelId{
    public static ChannelId createVerticalChanId(){  return createChanId("BHZ", MockSite.createSite()); }

    public static ChannelId createNorthChanId(){ return createChanId("BHN", MockSite.createSite()); }
    
    public static ChannelId createEastChanId(){ return createChanId("BHE", MockSite.createSite()); }

    public static ChannelId createOtherNetChanId(){
        return createChanId("BHZ", MockSite.createOtherSite());
    }
    
    public static ChannelId createOtherSiteSameStationChanId(){
        return createChanId("BHZ", MockSite.createOtherSiteSameStation());
    }

    public static ChannelId createChanId(String chanCode, SiteImpl site){
        ChannelId chanId = new ChannelId();
        chanId.channel_code = chanCode;
        chanId.network_id = site.getStation().getNetworkAttr().get_id();
        chanId.site_code = site.get_code();
        chanId.station_code = site.getStation().get_code();
        chanId.begin_time = site.getStation().getEffectiveTime().getBeginTime();
        return chanId;
    }

    public static ChannelId makeChanId(MicroSecondDate time) {
        ChannelId chanId =  createVerticalChanId();
        chanId.begin_time = time;
        chanId.network_id.begin_time = time;
        return chanId;
    }
}
