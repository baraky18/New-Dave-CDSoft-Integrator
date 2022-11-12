package com.cdsoft.integrator.mappers;

public interface Mapper <T, S>{

    T map(S s);
}
