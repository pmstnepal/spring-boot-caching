package com.caching.service;

import com.caching.entity.Developer;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Timestamp;

@Component
public class DeveloperSerializer implements StreamSerializer<Developer> {

    @Override
    public void write(ObjectDataOutput out, Developer developer) throws IOException {
        out.writeLong(developer.getId());
        out.writeString(developer.getName());
        out.writeString(developer.getExperience());
        out.writeString(developer.getCompanyName());
        out.writeString(developer.getPrimaryLanguage());
        out.writeLong(developer.getCrtTs().getTime());
    }

    @Override
    public Developer read(ObjectDataInput in) throws IOException {
        Developer developer = new Developer();
        developer.setId(in.readLong());
        developer.setName(in.readString());
        developer.setExperience(in.readString());
        developer.setCompanyName(in.readString());
        developer.setPrimaryLanguage(in.readString());
        developer.setCrtTs(new Timestamp(in.readLong()));
        return developer;
    }

    @Override
    public int getTypeId() {
        return 1;
    }
}
