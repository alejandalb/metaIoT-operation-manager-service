/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.model;

import jakarta.persistence.Embeddable;

/**
 * Embeddable class that contains the {@link Script} metadata
 */
@Embeddable
public class ScriptMetadata {
	// The name of the script
	private String name;
	// The version of the script
	private String version;
	// The author of the script
	private String author;
	// The type of the script (e.g., "update", "configuration", "diagnostic")
	private String scriptType;
	// The intended device type for the script (e.g., "sensor", "actuator")
	private String deviceType;
	// The minimum firmware version required to run the script
	private String minFirmwareVersion;
	// The maximum firmware version that can run the script
	private String maxFirmwareVersion;
	// The programming language of the script
	private String language;

	/**
	 * Default constructor
	 */
	public ScriptMetadata() {
		super();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return this.version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return this.author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the scriptType
	 */
	public String getScriptType() {
		return this.scriptType;
	}

	/**
	 * @param scriptType the scriptType to set
	 */
	public void setScriptType(String scriptType) {
		this.scriptType = scriptType;
	}

	/**
	 * @return the deviceType
	 */
	public String getDeviceType() {
		return this.deviceType;
	}

	/**
	 * @param deviceType the deviceType to set
	 */
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @return the minFirmwareVersion
	 */
	public String getMinFirmwareVersion() {
		return this.minFirmwareVersion;
	}

	/**
	 * @param minFirmwareVersion the minFirmwareVersion to set
	 */
	public void setMinFirmwareVersion(String minFirmwareVersion) {
		this.minFirmwareVersion = minFirmwareVersion;
	}

	/**
	 * @return the maxFirmwareVersion
	 */
	public String getMaxFirmwareVersion() {
		return this.maxFirmwareVersion;
	}

	/**
	 * @param maxFirmwareVersion the maxFirmwareVersion to set
	 */
	public void setMaxFirmwareVersion(String maxFirmwareVersion) {
		this.maxFirmwareVersion = maxFirmwareVersion;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return this.language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

}
