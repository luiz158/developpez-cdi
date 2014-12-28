package com.github.rmannibucau.developpez.cdi.produces;

import org.apache.johnzon.mapper.Mapper;
import org.apache.johnzon.mapper.MapperBuilder;

import javax.enterprise.inject.Produces;

public class MapperProducer {
    @Produces
    public Mapper mapper() {
        return new MapperBuilder().build();
    }
}
