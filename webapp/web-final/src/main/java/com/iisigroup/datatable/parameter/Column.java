package com.iisigroup.datatable.parameter;


public class Column {

    /**
     * Column's data source
     *
     * @see http://datatables.net/reference/option/columns.data
     */
    private String data;

    /**
     * Column's name
     *
     * @see http://datatables.net/reference/option/columns.name
     */
    private String name;

    /**
     * Flag to indicate if this column is searchable (true) or not (false).
     *
     * @see http://datatables.net/reference/option/columns.searchable
     */
    private Boolean searchable;

    /**
     * Flag to indicate if this column is orderable (true) or not (false).
     *
     * @see http://datatables.net/reference/option/columns.orderable
     */
    private Boolean orderable;

    /**
     * Search value to apply to this specific column.
     */
    private Search search;

    public Column() {
    }

    public Column(String data, String name, Boolean searchable,
            Boolean orderable, Search search) {
        super();
        this.data = data;
        this.name = name;
        this.searchable = searchable;
        this.orderable = orderable;
        this.search = search;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSearchable() {
        return searchable;
    }

    public void setSearchable(Boolean searchable) {
        this.searchable = searchable;
    }

    public Boolean getOrderable() {
        return orderable;
    }

    public void setOrderable(Boolean orderable) {
        this.orderable = orderable;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    /**
     * Set the search value to apply to this column
     *
     * @param searchValue
     *            if any, the search value to apply
     */
    public void setSearchValue(String searchValue) {
        this.search.setValue(searchValue);
    }

    @Override
    public String toString() {
        return "ColumnParameter [data=" + data + ", name=" + name
                + ", searchable=" + searchable + ", orderable=" + orderable
                + ", search=" + search + "]";
    }

}
