package edu.sc.seis.sod.mock.station;

import edu.sc.seis.sod.model.station.SiteId;
import edu.sc.seis.sod.model.station.StationImpl;

public class MockSiteId {

    public static SiteId createSiteId() {
        StationImpl sta = MockStation.createStation();
        return new SiteId(sta.get_id().network_id,
                          sta.get_code(),
                          "  ",
                          sta.get_id().begin_time);
    }

    public static SiteId createOtherSiteIdSameStation() {
        StationImpl sta = MockStation.createStation();
        return new SiteId(sta.get_id().network_id,
                          sta.get_code(),
                          "11",
                          sta.get_id().begin_time);
    }

    public static SiteId createOtherSiteId() {
        StationImpl sta = MockStation.createOtherStation();
        return new SiteId(sta.get_id().network_id,
                          sta.get_code(),
                          "00",
                          sta.get_id().begin_time);
    }

    public static SiteId createSiteId(StationImpl sta) {
        return createSiteId(sta, "  ");
    }

    public static SiteId createSiteId(StationImpl sta, String siteCode) {
        return new SiteId(sta.get_id().network_id,
                          sta.get_code(),
                          siteCode,
                          sta.get_id().begin_time);
    }
}