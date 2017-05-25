package edu.sc.seis.sod.mock.station;

import edu.sc.seis.sod.mock.MockLocation;
import edu.sc.seis.sod.model.common.Location;
import edu.sc.seis.sod.model.station.SiteImpl;
import edu.sc.seis.sod.model.station.StationIdUtil;
import edu.sc.seis.sod.model.station.StationImpl;

public class MockSite {

    public static SiteImpl createSite() {
        return new SiteImpl(MockSiteId.createSiteId(),
                            MockLocation.create(),
                            MockStation.createStation(),
                            "this is a site.  Isn't it grand?");
    }

    public static SiteImpl createOtherSite() {
        return new SiteImpl(MockSiteId.createOtherSiteId(),
                            MockLocation.createBerlin(),
                            MockStation.createOtherStation(),
                            "?dnarg ti t'nsI  .etis a is siht");
    }

    public static SiteImpl createOtherSiteSameStation() {
        return new SiteImpl(MockSiteId.createOtherSiteIdSameStation(),
                            MockLocation.create(),
                            MockStation.createStation(),
                            "this is another site.  Isn't it grander?");
    }

    public static SiteImpl createSite(StationImpl station) {
        return createSite(station, "00");
    }

    public static SiteImpl createSite(StationImpl station, String siteCode) {
        return new SiteImpl(MockSiteId.createSiteId(station, siteCode),
                            station.getLocation(),
                            station,
                            "Mock Site for station "
                                    + StationIdUtil.toStringNoDates(station.get_id()));
    }

    public static SiteImpl createSite(Location location) {
        StationImpl station = MockStation.createStation(location);
        return new SiteImpl(MockSiteId.createSiteId(station),
                            station.getLocation(),
                            station,
                            "Mock Site for station "
                                    + StationIdUtil.toStringNoDates(station.get_id()));
    }
}
