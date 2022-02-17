package org.example;

import io.cucumber.java.ParameterType;
import org.example.enums.Arithmetic;

public class ParameterTypes {

    @ParameterType("(ADD|SUBTRACT|MULTIPLY|DIVIDE)")
    public Arithmetic arithmetic(String function) {
        return Arithmetic.valueOf(function);
    }
}
