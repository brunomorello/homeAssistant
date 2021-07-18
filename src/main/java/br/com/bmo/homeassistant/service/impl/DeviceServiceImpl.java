package br.com.bmo.homeassistant.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.bmo.homeassistant.model.Device;
import br.com.bmo.homeassistant.service.DeviceService;

@Service("deviceService")
public class DeviceServiceImpl implements DeviceService {
	
	private final List<Device> devices = new ArrayList<>();
	
	public DeviceServiceImpl() {
		devices.add(new Device(1, "LG wash machine"));
		devices.add(new Device(2, "JBL"));
	}

	@Override
	public Device findDevice(Integer id) {
		return devices.stream()
				.filter(device -> device.getId() == id)
				.findFirst()
				.orElse(null);
	}

	@Override
	public List<Device> getAllDevices() {
		return new ArrayList<>(devices);
	}

	@Override
	public void updateDevice(Device device) {
		// TODO Auto-generated method stub

	}

}
