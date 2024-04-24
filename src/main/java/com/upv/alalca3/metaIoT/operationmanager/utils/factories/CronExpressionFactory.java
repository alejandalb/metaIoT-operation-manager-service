/**
 * 
 */
package com.upv.alalca3.metaIoT.operationmanager.utils.factories;

import java.time.LocalDateTime;

import com.upv.alalca3.metaIoT.operationmanager.utils.types.Frequency;

/**
 * Class used for converting between Dates and Cron expressions
 *
 */
public final class CronExpressionFactory {

	private CronExpressionFactory() {
	}

	/**
	 * Returns CRON expression from the provided {@link LocalDateTime} instance
	 * 
	 * @param dateTime  the {@link LocalDateTime} date used for getting the values
	 *                  for the cronExpression
	 * @param frequency the scheduling frequency
	 * @return the CRON expression
	 */
	public static String fromLocalDateTime(LocalDateTime dateTime, Frequency frequency) {
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
