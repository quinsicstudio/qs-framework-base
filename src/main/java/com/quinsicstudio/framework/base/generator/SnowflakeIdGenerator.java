package com.quinsicstudio.framework.base.generator;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.util.Properties;

public class SnowflakeIdGenerator implements IdentifierGenerator, Configurable {
    private long machineId = 0;
    private long timestamp = 0;
    private long sequence = 0;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        long id;
        while ((id = doGenerate()) == 0) ;
        return id;
    }

    private synchronized long doGenerate() {
        long currentTimestamp = System.currentTimeMillis();

        if (currentTimestamp > timestamp) {
            timestamp = currentTimestamp;
            sequence = 0;
        }
        else if (currentTimestamp == timestamp) {
            //sequence greater than max allowed sequence, try again
            if (sequence >= (2 ^ 12)) return 0;
        }
        //clock drift
        else if (currentTimestamp < timestamp) {
            return 0;
        }

        return (timestamp << (64 - 1 - 41)) | (machineId << (64 - 1 - 41 - 10)) | sequence++;
    }

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        this.machineId = SnowflakeIdGeneratorConfiguration.MACHINE_ID;
        if (machineId < 0 || machineId > 1024) throw new IllegalStateException("illegal machine id.");
    }
}
