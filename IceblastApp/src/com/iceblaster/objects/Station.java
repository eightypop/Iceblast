package com.iceblaster.objects;

import java.net.MalformedURLException;
import java.net.URL;

public class Station {

	private String name;
	
	private URL stationUrl;
	
	// default constructor
	public Station() {
		setName("New Station");
		try {
			// come up with some other default or never use this constructor
			setStationUrl("http://ds106.us/ds106-radio/");
		} catch (MalformedURLException e) {
			// definitely not a malformed URL - this won't get called
			e.printStackTrace();
		}
	}
	
	// we'll probably use this one most often
	public Station(String name, String url) throws MalformedURLException {
		setName(name);
		setStationUrl(url);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public URL getStationUrl() {
		return stationUrl;
	}

	public void setStationUrl(URL stationUrl) {
		this.stationUrl = stationUrl;
	}
	
	public void setStationUrl(String stationUrl) throws MalformedURLException {
		this.stationUrl = new URL(stationUrl);
	}
	
	
	
}
