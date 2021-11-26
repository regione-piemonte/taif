/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.util.guava.common.base;

/**
 *
 * @author 71740 (Simone Cornacchia)
 */
public final class Preconditions {

	private static final String DEFAULT_CHECK_ELEMENT_INDEX_DESC = "index";

	/**
	 * Ensures that an object reference passed as a parameter
	 * to the calling method is not null.
	 *
	 * @param reference an object reference
	 * @return the non-null reference that was validated
	 * @throws IllegalArgumentException if {@code reference} is null
	 */
	public static <T> T checkNotNull(T reference) {
		if (reference == null) {
//			throw new NullPointerException();
			throw new IllegalArgumentException();
		}

		return reference;
	}

	/**
	 * Ensures that an object reference passed as a parameter
	 * to the calling method is not null.
	 *
	 * @param reference an object reference
	 * @param errorMessage the exception message to use if the check fails;
	 * 	      will be converted to a string using {@link String#valueOf(Object)}
	 * @return the non-null reference that was validated
	 * @throws IllegalArgumentException if {@code reference} is null
	 */
	public static <T> T checkNotNull(T reference, Object errorMessage) {
		if (reference == null) {
//			throw new NullPointerException();
			throw new IllegalArgumentException(String.valueOf(errorMessage));
		}

		return reference;
	}

	/**
	 * Ensures that an object reference passed as a parameter
	 * to the calling method is not null.
	 *
	 * @param reference an object reference
	 * @param errorMessageTemplate a template for the exception message should the check fail.
	 *        The message is formed by replacing each {@code %s} placeholder in the template with an argument.
	 *        These are matched by position - the first {@code %s} gets {@code errorMessageArgs[0]}, etc.
	 *        Unmatched arguments will be appended to the formatted message in square braces.
	 *        Unmatched placeholders will be left as-is.
	 * @param errorMessageArgs the arguments to be substituted into the message template.
	 *        Arguments are converted to strings using {@link String#valueOf(Object)}.
	 * @throws IllegalStateException if expression is false
	 */
	public static <T> T checkNotNull(T reference, String errorMessageTemplate, Object... errorMessageArgs) {
		if (reference == null) {
//			throw new NullPointerException();
			throw new IllegalArgumentException(format(errorMessageTemplate, errorMessageArgs));
		}

		return reference;
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters
	 * to the calling method.
	 *
	 * @param expression a boolean expression
	 * @throws IllegalArgumentException if {@code expression} is false
	 */
	public static void checkArgument(boolean expression) {
		if (! expression) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters
	 * to the calling method.
	 *
	 * @param expression a boolean expression
	 * @param errorMessage the exception message to use if the check fails;
	 * 	      will be converted to a string using {@link String#valueOf(Object)}
	 * @throws IllegalArgumentException if {@code expression} is false
	 */
	public static void checkArgument(boolean expression, Object errorMessage) {
		if (! expression) {
			throw new IllegalArgumentException(String.valueOf(errorMessage));
		}
	}

	/**
	 * Ensures the truth of an expression involving one or more parameters
	 * to the calling method.
	 *
	 * @param expression a boolean expression
	 * @param errorMessageTemplate a template for the exception message should the check fail.
	 *        The message is formed by replacing each {@code %s} placeholder in the template with an argument.
	 *        These are matched by position - the first {@code %s} gets {@code errorMessageArgs[0]}, etc.
	 *        Unmatched arguments will be appended to the formatted message in square braces.
	 *        Unmatched placeholders will be left as-is.
	 * @param errorMessageArgs the arguments to be substituted into the message template.
	 *        Arguments are converted to strings using {@link String#valueOf(Object)}.
	 * @throws IllegalStateException if expression is false
	 */
	public static void checkArgument(boolean expression, String errorMessageTemplate, Object... errorMessageArgs) {
		if (! expression) {
			throw new IllegalStateException(format(errorMessageTemplate, errorMessageArgs));
		}
	}

	/**
	 * Ensures the truth of an expression involving the state of the calling instance,
	 * but not involving any parameters to the calling method.
	 *
	 * @param expression a boolean expression
	 * @throws IllegalStateException if expression is false
	 */
	public static void checkState(boolean expression) {
		if (! expression) {
			throw new IllegalStateException();
		}
	}

	/**
	 * Ensures the truth of an expression involving the state of the calling instance,
	 * but not involving any parameters to the calling method.
	 *
	 * @param expression a boolean expression
	 * @param errorMessage the exception message to use if the check fails;
	 *        will be converted to a string using {@link String#valueOf(Object)}.
	 * @throws IllegalStateException if expression is false
	 */
	public static void checkState(boolean expression, Object errorMessage) {
		if (! expression) {
			throw new IllegalStateException(String.valueOf(errorMessage));
		}
	}

	/**
	 * Ensures the truth of an expression involving the state of the calling instance,
	 * but not involving any parameters to the calling method.
	 *
	 * @param expression a boolean expression
	 * @param errorMessageTemplate a template for the exception message should the check fail.
	 *        The message is formed by replacing each {@code %s} placeholder in the template with an argument.
	 *        These are matched by position - the first {@code %s} gets {@code errorMessageArgs[0]}, etc.
	 *        Unmatched arguments will be appended to the formatted message in square braces.
	 *        Unmatched placeholders will be left as-is.
	 * @param errorMessageArgs the arguments to be substituted into the message template.
	 *        Arguments are converted to strings using {@link String#valueOf(Object)}.
	 * @throws IllegalStateException if expression is false
	 */
	public static void checkState(boolean expression, String errorMessageTemplate, Object... errorMessageArgs) {
		if (! expression) {
			throw new IllegalStateException(format(errorMessageTemplate, errorMessageArgs));
		}
	}

	/**
	 * Ensures that {@code index} specifies a valid <i>element</i> in an array,
	 * list or string of size {@code size}. An element index may range from zero,
	 * inclusive, to {@code size}, exclusive.
	 *
	 * @param index a user-supplied index identifying an element of an array, list or string
	 * @param size the size of that array, list or string
	 * @return the value of {@code index}
	 * @throws IndexOutOfBoundsException if {@code index} is negative or is not less than {@code size}
	 * @throws IllegalArgumentException if {@code size} is negative
	 */
	public static int checkElementIndex(int index, int size) {
		return checkElementIndex(index, size, DEFAULT_CHECK_ELEMENT_INDEX_DESC);
	}

	/**
	 * Ensures that {@code index} specifies a valid <i>element</i> in an array,
	 * list or string of size {@code size}. An element index may range from zero,
	 * inclusive, to {@code size}, exclusive.
	 *
	 * @param index a user-supplied index identifying an element of an array, list or string
	 * @param size the size of that array, list or string
	 * @param desc the text to use to describe this index in an error message
	 * @return the value of {@code index}
	 * @throws IndexOutOfBoundsException if {@code index} is negative or is not less than {@code size}
	 * @throws IllegalArgumentException if {@code size} is negative
	 */
	public static int checkElementIndex(int index, int size, String desc) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(badElementIndex(index, size, desc == null ? DEFAULT_CHECK_ELEMENT_INDEX_DESC : desc));
		}

		return index;
	}

	/**
	 * Substitutes  each {@code %s} placeholder in the template with an argument.
	 * These are matched by position - the first {@code %s} gets {@code errorMessageArgs[0]}, etc.
	 * Unmatched arguments will be appended to the formatted message in square braces.
	 * Unmatched placeholders will be left as-is.
	 *
	 * @param template  a non-null string containing 0 or more %s placeholders.
	 * @param args the arguments to be substituted into the message template.
	 *             Arguments are converted to strings using {@link String#valueOf(Object)}.
	 *             Arguments can be null.
	 * @return the formatted template
	 */
	private static String format(String template, Object... args) {
		template = String.valueOf(template); // null -> "null"

		// start substituting the arguments into the '%s' placeholders
		StringBuilder builder = new StringBuilder(template.length() + 16 * args.length);
		int templateStart = 0;
		int i = 0;
		while (i < args.length) {
			int placeholderStart = template.indexOf("%s", templateStart);
			if (placeholderStart == -1) {
				break;
			}
			builder.append(template.substring(templateStart, placeholderStart));
			builder.append(args[i++]);
			templateStart = placeholderStart + 2;
		}
		builder.append(template.substring(templateStart));

		// if we run out of placeholders, append the extra args in square braces
		if (i < args.length) {
			builder.append(" [");
			builder.append(args[i++]);
			while (i < args.length) {
				builder.append(", ");
				builder.append(args[i++]);
			}
			builder.append(']');
		}

		return builder.toString();
	}

	private static String badElementIndex(int index, int size, String desc) {
		if (index < 0) {
			return format("%s (%s) must not be negative", desc, index);
		} else if (size < 0) {
			throw new IllegalArgumentException("negative size: " + size);
		} else { // index >= size
			return format("%s (%s) must be less than size (%s)", desc, index, size);
		}
	}

	/**
	 * Constructor.
	 */
	private Preconditions() { /* NO-OP */ }

}
