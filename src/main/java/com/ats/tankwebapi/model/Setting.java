package com.ats.tankwebapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_settings")
public class Setting {
	@Id
	private int settingsId;

	private String settingsKey;
	
	private String settingsValue;

	public int getSettingsId() {
		return settingsId;
	}

	public void setSettingsId(int settingsId) {
		this.settingsId = settingsId;
	}

	public String getSettingsKey() {
		return settingsKey;
	}

	public void setSettingsKey(String settingsKey) {
		this.settingsKey = settingsKey;
	}

	public String getSettingsValue() {
		return settingsValue;
	}

	public void setSettingsValue(String settingsValue) {
		this.settingsValue = settingsValue;
	}

	@Override
	public String toString() {
		return "Setting [settingsId=" + settingsId + ", settingsKey=" + settingsKey + ", settingsValue=" + settingsValue
				+ "]";
	}
	
	
	
	
	
}
