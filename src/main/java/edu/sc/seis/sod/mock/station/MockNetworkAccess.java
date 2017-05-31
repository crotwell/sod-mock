/**
 * MyNetworkAccess.java
 * 
 * @author Created by Omnicore CodeGuide
 */
package edu.sc.seis.sod.mock.station;

import edu.sc.seis.sod.model.station.ChannelId;
import edu.sc.seis.sod.model.station.ChannelIdUtil;
import edu.sc.seis.sod.model.station.ChannelImpl;
import edu.sc.seis.sod.model.station.NetworkAttrImpl;
import edu.sc.seis.sod.model.station.StationId;
import edu.sc.seis.sod.model.station.StationIdUtil;
import edu.sc.seis.sod.model.station.StationImpl;

public class MockNetworkAccess  {

    public static MockNetworkAccess createNetworkAccess() {
        return new MockNetworkAccess();
    }

    public static MockNetworkAccess createOtherNetworkAccess() {
        return new MockNetworkAccess(MockNetworkAttr.createOtherNetworkAttr(),
                                     MockStation.createOtherStation(),
                                     new ChannelImpl[] {MockChannel.createOtherNetChan()});
    }

    public static MockNetworkAccess createManySplendoredNetworkAccess() {
        StationImpl[] stations = MockStation.createMultiSplendoredStations();
        ChannelImpl[][] channels = new ChannelImpl[stations.length][];
        for(int i = 0; i < stations.length; i++) {
            channels[i] = MockChannel.createMotionVector(stations[i]);
        }
        return new MockNetworkAccess(MockNetworkAttr.createMultiSplendoredAttr(),
                                     stations,
                                     channels);
    }

    private NetworkAttrImpl attributes;

    public MockNetworkAccess(NetworkAttrImpl attributes,
                             StationImpl station,
                             ChannelImpl[] channels) {
        this(attributes, new StationImpl[] {station}, make2DArray(channels));
    }

    private static ChannelImpl[][] make2DArray(ChannelImpl[] channels) {
        ChannelImpl[][] channels2d = new ChannelImpl[1][];
        channels2d[0] = channels;
        return channels2d;
    }

    public MockNetworkAccess() {
        this(MockNetworkAttr.createNetworkAttr(),
             MockStation.createStation(),
             new ChannelImpl[] {MockChannel.createChannel(),
                            MockChannel.createNorthChannel(),
                            MockChannel.createEastChannel()});
    }

    private MockNetworkAccess(NetworkAttrImpl attributes,
                              StationImpl station[],
                              ChannelImpl[][] channels) {
        this.attributes = attributes;
        this.stations = station;
        this.channels = channels;
    }

    public StationImpl[] retrieve_stations() {
        return stations;
    }

    public ChannelImpl retrieve_channel(ChannelId p1) {
        for(int j = 0; j < channels.length; j++) {
            for(int i = 0; i < channels[j].length; i++) {
                if(ChannelIdUtil.areEqual(channels[j][i].get_id(), p1)) {
                    return channels[j][i];
                }
            }
        }
        return null;
    }

    public ChannelImpl[] retrieve_for_station(StationId p1) {
        for(int i = 0; i < stations.length; i++) {
            if(StationIdUtil.areEqual(p1, stations[i].get_id())) {
                return channels[i];
            }
        }
        return new ChannelImpl[] {};
    }

    public NetworkAttrImpl get_attributes() {
        return attributes;
    }

    private StationImpl[] stations;

    private ChannelImpl[][] channels;
}