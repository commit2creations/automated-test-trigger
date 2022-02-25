package org.example.enums;

public enum MathBranch {
    ALGEBRA("alg"),
    CALCULUS("clcs"),
    STATISTICS("stat"),
    TRIGONOMETRY("trig"),
    GRAPH("");

    private String branchElementClass;

    MathBranch(String branchElementClass){
        this.branchElementClass = branchElementClass;
    }

    public String getBranch(){
        return branchElementClass;
    }
}
