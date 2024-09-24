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
     * @param base      the base for the operation publish topic
     * @param operation the operation that will be published
     * @return the publish topic
     */
    public static <E extends OperationDTO> String buildOperationPublishTopic(String base, E operation) {
	StringBuilder sb = new StringBuilder();
	sb.append(base);
	sb.append(operation.getId());
	sb.append("/");
	sb.append(operation.getType());
	sb.append("/");
	sb.append(operation.getTargetDevice().getDeviceType());
	sb.append("/");
	sb.append(operation.getTargetDevice().getGroup());
	return sb.toString();
    }

}
