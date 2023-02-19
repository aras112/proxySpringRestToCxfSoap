package pl.bpsa.java2spring.model;

import lombok.Data;

@Data
public class ParamModel {
    private String name;
    private String clazz;
    private Boolean last = false;
}
