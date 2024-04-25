/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.utils;

import com.upv.alalca3.metaIoT.operationmanager.model.dto.OperationDTO;

/**
 * 
 */
public final class MqttTopicUtils {

	private MqttTopicUtils() {
	}

	/**
	 * Returns a
	 * 
	 * @param base topic base
	 * @return the listener topic
	 */
	public static String buildListenerTopic(String base) {
		return base + "#";
	}

	/**
	 * Builds the publishing topic for a {@link OperationDTO}
	 * 
	 * @param operation the operation that will be published
	 * @return the publish topic
	 */
	public static <E extends OperationDTO> String buildOperationPublishTopic(E operation) {
		return operation.toString();
	}

}
