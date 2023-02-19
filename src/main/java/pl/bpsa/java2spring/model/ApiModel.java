package pl.bpsa.java2spring.model;

import lombok.Data;

import java.util.List;

@Data
public class ApiModel {
    private String packageName, className, routePath, packageProxyName;

    private List<OperationModel> operations;
}
