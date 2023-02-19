package pl.bpsa.java2spring;

import lombok.var;
import org.apache.commons.lang3.StringUtils;
import pl.bpsa.java2spring.model.ApiModel;
import pl.bpsa.java2spring.model.OperationModel;
import pl.bpsa.java2spring.model.ParamModel;

import javax.jws.WebService;
import javax.xml.ws.Holder;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

public class ClassParser {

    public static <T> ApiModel parse(Class<T> clazz) {
        ApiModel apiModel = new ApiModel();
        apiModel.setClassName(clazz.getSimpleName());
        apiModel.setPackageName(clazz.getPackage().getName());
        apiModel.setPackageProxyName(clazz.getPackage().getName());

        WebService annotation = clazz.getAnnotation(WebService.class);
        apiModel.setRoutePath("/" + annotation.name());
        apiModel.setOperations(new ArrayList<>());

        for (var method : clazz.getMethods()) {
            OperationModel operationModel = new OperationModel();
            operationModel.setName(method.getName());
            operationModel.setPath("/" + method.getName());

            ParamModel result = new ParamModel();
            result.setClazz(method.getReturnType().getName());
            result.setName("return");
            operationModel.setOutput(result);
            operationModel.setOutputs(new ArrayList<>());
            operationModel.setInputs(new ArrayList<>());


            for (var param : method.getParameters()) {
                ParamModel input = new ParamModel();

                if (param.getType().equals(Holder.class)) {
                    var type = ((ParameterizedType) param.getParameterizedType()).getActualTypeArguments()[0];
                    input.setClazz(type.getTypeName());
                    operationModel.setMultipleResponses(true);
                    input.setName(param.getName());
                    operationModel.getOutputs().add(input);
                    ParamModel newClass = new ParamModel();
                    newClass.setClazz(StringUtils.capitalize(operationModel.getName()) + "Response");
                    newClass.setName("response");
                    operationModel.setOutput(newClass);
                } else {
                    input.setClazz(param.getType().getName());
                    input.setName(param.getName());
                    operationModel.getInputs().add(input);
                }
            }

            ParamModel input = new ParamModel();
            input.setClazz(StringUtils.capitalize(operationModel.getName()) + "Request");
            input.setName("request");
            operationModel.setInput(input);

            if (!operationModel.getInputs().isEmpty()) {
                operationModel.getInputs().get(operationModel.getInputs().size() - 1).setLast(true);
            }
            if (!operationModel.getOutputs().isEmpty()) {
                operationModel.getOutputs().get(operationModel.getOutputs().size() - 1).setLast(true);
            }
            apiModel.getOperations().add(operationModel);
        }


        return apiModel;
    }

}
