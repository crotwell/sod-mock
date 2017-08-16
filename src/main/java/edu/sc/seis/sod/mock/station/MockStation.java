package edu.sc.seis.sod.mock.station;

import edu.sc.seis.seisFile.fdsnws.stationxml.Station;
import edu.sc.seis.sod.mock.MockLocation;
import edu.sc.seis.sod.model.common.Location;
import edu.sc.seis.sod.model.common.UnitImpl;

public class MockStation {

    public static Station createStation() {
    		Station out = new Station(MockNetworkAttr.createNetworkAttr(), "STTN");
    		out.setDescription("this is a test");
    		out.setStartDateTime(out.getNetwork().getStartDateTime());
    		out.setEndDate("19991231T235959.999Z");
    		Location berlin = MockLocation.createBerlin();
    		out.setLatitude(berlin.latitude);
    		out.setLongitude(berlin.longitude);
    		out.setElevation((float)berlin.elevation.getValue(UnitImpl.METER));
    		out.setName("Test Station");
    		return out;
    }

    public static Station createRestartedStation() {
		Station out = new Station(MockNetworkAttr.createNetworkAttr(), "STTN");
		out.setDescription("this is a test");
		out.setStartDate("20000101T000000.000Z");
		Location berlin = MockLocation.createBerlin();
		out.setLatitude(berlin.latitude);
		out.setLongitude(berlin.longitude);
		out.setElevation((float)berlin.elevation.getValue(UnitImpl.METER));
		out.setName("Test Station");
		return out;
    }

    public static Station createOtherStation() {
		Station out = new Station(MockNetworkAttr.createOtherNetworkAttr(), "STB2");
		out.setDescription("tset a si siht");
		out.setStartDateTime(out.getNetwork().getStartDateTime());
		out.setEndDate("19991231T235959.999Z");
		Location berlin = MockLocation.createBerlin();
		out.setLatitude(berlin.latitude + 1);
		out.setLongitude(berlin.longitude);
		out.setElevation((float)berlin.elevation.getValue(UnitImpl.METER));
		out.setName("Noitats tset");
		return out;
    }

    public static Station[] createMultiSplendoredStations() {
        return createMultiSplendoredStations(4, 5);
    }
    
    public static Station createCloseStation(Station in) {
		Station out = new Station(MockNetworkAttr.createNetworkAttr(), "CLS2U");
		out.setDescription("Close to you, is this too close?");
		out.setStartDateTime(out.getNetwork().getStartDateTime());
		out.setEndDate("19991231T235959.999Z");
		Location berlin = MockLocation.createBerlin();
		out.setLatitude(berlin.latitude + 0.01f);
		out.setLongitude(berlin.longitude);
		out.setElevation((float)berlin.elevation.getValue(UnitImpl.METER));
		out.setName("Close Station");
		return out;
    }

    public static Station[] createMultiSplendoredStations(int rows, int columns) {
        Station[] stations = new Station[rows * columns];
        Location[] locations = MockLocation.create(rows, columns);
        for(int i = 0; i < stations.length; i++) {
        	    Station out = new Station(MockNetworkAttr.createMultiSplendoredAttr(), "MS"+i);
        	    out.setDescription("Grid of Stations "+i);
        	    out.setStartDate("20000101T000000.000Z");
        	    Location berlin = MockLocation.createBerlin();
        	    out.setLatitude(berlin.latitude);
        	    out.setLongitude(berlin.longitude);
        	    out.setElevation((float)berlin.elevation.getValue(UnitImpl.METER));
        	    out.setName("Multi" + i);
        	    stations[i] = out;
        }
        return stations;
    }

    public static Station createStation(Location location) {
		Station out = new Station(MockNetworkAttr.createNetworkAttr(), "SMWHR");
		out.setDescription("Somewhere beyond the rainbow.");
		out.setStartDateTime(out.getNetwork().getStartDateTime());
		out.setLatitude(location.latitude);
		out.setLongitude(location.longitude);
		out.setElevation((float)location.elevation.getValue(UnitImpl.METER));
		out.setName("Somewhere "+location.latitude+" "+location.longitude);
		return out;
    }
}