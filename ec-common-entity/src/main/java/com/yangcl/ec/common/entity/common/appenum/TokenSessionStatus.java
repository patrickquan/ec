package com.yangcl.ec.common.entity.common.appenum;

public enum TokenSessionStatus {
    Normal("1"),
    Overdue("2"),
    Expired("3");

    private final String status;
    private TokenSessionStatus(final String status){
        this.status=status;
    }

    @Override
    public String toString() {
        return status;
    }
}
