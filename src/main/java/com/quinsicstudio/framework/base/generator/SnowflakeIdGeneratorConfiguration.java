package com.quinsicstudio.framework.base.generator;

public class SnowflakeIdGeneratorConfiguration {
    //hibernate generator workaround...
    public static int MACHINE_ID;

    private int machineId;

    public void setMachineId(int machineId) {
        this.machineId = machineId;
        MACHINE_ID = machineId;
    }
}
