package com.bmapute.chocolate.infrastructure.errorHandler;

import java.util.Date;

public record ErrorMessage(int code, Date timestamp, String message) {
}
