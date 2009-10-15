/*
 * Copyright 2002-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.ui.format.jodatime;

import java.text.ParseException;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.ui.format.Formatter;

/**
 * {@link Formatter} implementation to handle JodaTime {@link DateTime} instances.
 * @author Oliver Gierke
 */
public class DateTimeFormatter implements Formatter<DateTime> {

	private org.joda.time.format.DateTimeFormatter formatter;

	/**
	 * Creates a new {@link DateTimeFormatter} for the given JodaTime formatting pattern.
	 * @param pattern
	 * @see DateTimeFormat
	 */
	public DateTimeFormatter(String pattern) {
		this.formatter = DateTimeFormat.forPattern(pattern);
	}

	/**
	 * Creates a new {@link DateTimeFormatter} for the given JodaTime formatter.
	 */
	public DateTimeFormatter(org.joda.time.format.DateTimeFormatter formatter) {
		this.formatter = formatter;
	}

	public String format(DateTime object, Locale locale) {
		return null == object ? "" : object.toString(formatter);
	}

	public DateTime parse(String formatted, Locale locale) throws ParseException {
		return formatter.withLocale(locale).parseDateTime(formatted);
	}
}
