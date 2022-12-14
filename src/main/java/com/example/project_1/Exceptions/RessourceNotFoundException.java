package com.example.project_1.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RessourceNotFoundException extends RuntimeException{
    private String ressourceName;
    private String fieldName;
    private Object fieldValue;

    public RessourceNotFoundException(String ressourceName, String fieldName, Object fieldValue) {
        super(String.format(ressourceName+" source not found with name : "+fieldName+" and value : "+fieldValue));
        this.ressourceName = ressourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getRessourceName() {
        return ressourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
