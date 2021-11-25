package com.quinsicstudio.framework.base.generator;

import java.util.Date;

public class DateGenerator {
    public Date generateNewDate(long add) {
        return new Date(System.currentTimeMillis() + add);
    }
}
