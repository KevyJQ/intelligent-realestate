package com.intelligent.realestate.exceptions;

/*
 * Define las exceptions que el sistema puede lanzar.
 */
public class Exceptions {

	@SuppressWarnings("serial")
	public static class DbException extends RuntimeException {
		public DbException(Throwable throwable) {
			super(throwable);
		}

		public DbException(String msg, Throwable throwable) {
			super(msg, throwable);
		}
	}
}
