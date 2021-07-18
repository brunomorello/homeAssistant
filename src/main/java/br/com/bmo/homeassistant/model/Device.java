package br.com.bmo.homeassistant.model;

import lombok.Setter;
import lombok.Value;

@Value
@Setter
public class Device {

	private Integer id;
	private String name;
}
