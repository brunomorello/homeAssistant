package br.com.bmo.homeassistant.service;

import java.util.List;

import br.com.bmo.homeassistant.model.Device;

public interface DeviceService {

	Device findDevice(Integer id);
	
	List<Device> getAllDevices();
	
	void updateDevice(Device device);
}
