package pl.bpsa.java2spring.model;

import lombok.Data;

import java.util.List;

@Data
public class OperationModel {
    private List<ParamModel> inputs;
    private List<ParamModel> outputs;

    private String path;

    private String inputLine;

    private ParamModel output;
    private ParamModel input;

    private Boolean multipleResponses = false;
    private Boolean multipleRequests = false;

    private String name;
}
