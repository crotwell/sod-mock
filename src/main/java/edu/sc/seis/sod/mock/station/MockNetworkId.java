package edu.sc.seis.sod.mock.station;

import edu.sc.seis.sod.mock.Defaults;
import edu.sc.seis.sod.model.station.NetworkId;

public class MockNetworkId{
    public static NetworkId createNetworkID(){
        NetworkId mockId = new NetworkId();
        mockId.network_code = "XX";
        mockId.begin_time = Defaults.EPOCH;
        return mockId;
    }

    public static NetworkId createOtherNetworkID(){
        NetworkId mockId = new NetworkId();
        mockId.network_code = "SS";
        mockId.begin_time = Defaults.WALL_FALL;
        return mockId;
    }

    public static NetworkId createMutliSplendoredNetworkID(){
        NetworkId mockId = new NetworkId();
        mockId.network_code = "MS";
        mockId.begin_time = Defaults.WALL_FALL;
        return mockId;
    }
}
