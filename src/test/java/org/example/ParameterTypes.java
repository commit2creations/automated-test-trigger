package org.example;

import io.cucumber.java.ParameterType;
import org.example.enums.Arithmetic;
import org.example.enums.ModalShould;

import java.lang.reflect.MalformedParametersException;

public class ParameterTypes {

    @ParameterType("(add|subtract|multiply|divide)")
    public Arithmetic arithmetic(String function) {
        return Arithmetic.valueOf(function.toUpperCase());
    }

    @ParameterType("(should|shouldn't|should not)")
    public ModalShould modalShould(String auxiliary) {
        switch (auxiliary){
            case "should":
                return ModalShould.SHOULD;
            case "shouldn't":
            case "should not":
                return ModalShould.SHOULD_NOT;
            default:
                throw new MalformedParametersException("This word is not a modal verb of the should auxiliary");
        }
    }
}
