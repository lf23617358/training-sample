package com.iisigroup.datatable.parameter;


public class Order {

    /**
     * Column to which ordering should be applied. This is an index reference to
     * the columns array of information that is also submitted to the server.
     */
    private Integer column;

    /**
     * Ordering direction for this column. It will be asc or desc to indicate
     * ascending ordering or descending ordering, respectively.
     */
    private String dir;

    public Order() {
    }

    public Order(Integer column, String dir) {
        super();
        this.column = column;
        this.dir = dir;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return "OrderParameter [column=" + column + ", dir=" + dir + "]";
    }

}
