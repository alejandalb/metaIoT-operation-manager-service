/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.factories;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.upv.alalca3.metaIoT.operationmanager.utils.enums.Frequency;

/**
 * Class used for converting between Dates and Cron expressions
 *
 */
public final class CronExpressionFactory {

	private CronExpressionFactory() {
	}

	/**
	 * Returns CRON expression that corresponds the provided {@link Instant} in a
	 * specific {@link Frequency}
	 * 
	 * @param instant   the {@link Instant} timestamp used for getting the values
	 *                  for the cronExpression
	 * @param frequency the scheduling frequency
	 * @return the CRON expression
	 */
	public static String fromInstantAndFrequency(Instant instant, Frequency frequency) {
		LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

		String seconds = Integer.toString(dateTime.getSecond());
		String minute = Integer.toString(dateTime.getMinute());
		String hour = Integer.toString(dateTime.getHour());
		String dayOfMonth = Integer.toString(dateTime.getDayOfMonth());
		String month = Integer.toString(dateTime.getMonthValue());
		String dayOfWeek = "?";

		switch (frequency) {
		case DAILY:
			// Reset dayOfMonth, month and dayOfWeek to "*"
			dayOfMonth = "*";
			month = "*";
			dayOfWeek = "*";
			break;
		case WEEKLY:
			// Reset dayOfMonth and month to "*"
			dayOfMonth = "*";
			month = "*";
			// Set dayOfWeek to the day of the week
			dayOfWeek = Integer.toString(dateTime.getDayOfWeek().getValue());
			break;
		case MONTHLY:
			// Reset month and dayOfWeek to "*"
			month = "*";
			dayOfWeek = "*";
			break;
		case YEARLY:
			// Reset dayOfWeek to "*"
			dayOfWeek = "*";
			break;
		}

		return String.format("%s %s %s %s %s %s", seconds, minute, hour, dayOfMonth, month, dayOfWeek);
	}
}
