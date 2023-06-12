package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {

    Controller myApp;

    @Before
    public void setUp() throws Exception {
        myApp = new Controller();
    }

    @After
    public void tearDown() throws Exception {
    }


//--- This section tests adding valid devices to list of controlled devices ---

    @Test
    public void testAddFistValidDeviceSucceeds() {
        assertTrue("Add device should succeed", myApp.addDevice(ControlDeviceType.CONTROLDEVICE_FAN_DRIVER, "1111", 0, 100, 20, 50));
        assertTrue("Device id=1111 should be in list", myApp.isDeviceInList("1111"));
        assertEquals("There should be 1 device in list of controlled devices", myApp.getNumDevices(), 1);
    }


}
