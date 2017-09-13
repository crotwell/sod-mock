package edu.sc.seis.mock.station;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.sc.seis.seisFile.fdsnws.stationxml.Station;
import edu.sc.seis.sod.mock.station.MockStation;

public class MockStationTest {

    @Test
    public void testCreateStation() {
        Station s = MockStation.createStation();
        assertEquals("Station End", MockStation.YEAR_1999, s.getEndDate());
    }

}
