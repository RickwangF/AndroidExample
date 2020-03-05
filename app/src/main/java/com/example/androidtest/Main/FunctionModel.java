package com.example.androidtest.Main;

public class FunctionModel {
    String functionName;

    String className;

    public FunctionModel() {
        this.functionName = "";
        this.className = "";
    }

    public FunctionModel(String functionName, String className) {
        this.functionName = functionName;
        this.className = className;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
