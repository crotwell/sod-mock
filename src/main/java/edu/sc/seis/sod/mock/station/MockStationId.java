package edu.sc.seis.sod.mock.station;

import edu.sc.seis.sod.mock.Defaults;
import edu.sc.seis.sod.model.station.StationId;

public class MockStationId {

    //this station is used as station in MockSite and Channel.
    //It has one site and three channels
    public static StationId createStationId() {
        return new StationId(MockNetworkId.createNetworkID(),
                             "STTN",
                             Defaults.EPOCH);
    }

    public static StationId createRestartedStationId() {
        return new StationId(MockNetworkId.createNetworkID(),
                             "STTN",
                             Defaults.WALL_FALL);
    }

    public static StationId createCloseStationId() {
        return new StationId(MockNetworkId.createNetworkID(),
                             "CLOSE",
                             Defaults.WALL_FALL);
    }
    
    //this station is used as other station in MockSite and Channel as well.
    //It has one site and one channel
    public static StationId createOtherStationId() {
        return new StationId(MockNetworkId.createOtherNetworkID(),
                             "NTTS",
                             Defaults.WALL_FALL);
    }

    public static StationId createMultiSplendoredId(String code) {
        return new StationId(MockNetworkId.createMutliSplendoredNetworkID(),
                             code,
                             Defaults.WALL_FALL);
    }
    
    
}