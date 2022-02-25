package org.example;

import io.cucumber.java.ParameterType;
import org.example.enums.Arithmetic;
import org.example.enums.MathBranch;
import org.example.enums.ModalShould;

import java.lang.reflect.MalformedParametersException;

public class ParameterTypes {

    @ParameterType("(add|subtract|multiply|divide|open parenthesis|closed parenthesis|backspace)")
    public Arithmetic arithmetic(String function) {
        return Arithmetic.valueOf(function.toUpperCase().replace(' ', '_'));
    }

    @ParameterType("(should|shouldn't|should not)")
    public ModalShould modalShould(String auxiliary) {
        switch (auxiliary) {
            case "should":
                return ModalShould.SHOULD;
            case "shouldn't":
            case "should not":
                return ModalShould.SHOULD_NOT;
        }
        return null;
    }

    @ParameterType("(algebra|calculus|statistics|trigonometry|graph)")
    public MathBranch mathBranch(String branch) {
        return MathBranch.valueOf(branch.toUpperCase());
    }
}
