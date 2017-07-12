package com.hexagon.clinic.dao;

public class FilterStruct {

    private String rawFilter;
    private String pathFilter;
    private String filterValue;

    public FilterStruct(String filterString) {

        if (filterString == null)
            return;

        this.rawFilter = filterString;

        String[] split = filterString.split(":");

        if(split.length != 2)
            throw new RuntimeException("Filter should be like this pattern 'path':'value' ");

        pathFilter = split[0];
        filterValue = split[1];
    }

    public String getRawFilter() {
        return rawFilter;
    }

    public void setRawFilter(String rawFilter) {
        this.rawFilter = rawFilter;
    }

    public String getPathFilter() {
        return pathFilter;
    }

    public void setPathFilter(String pathFilter) {
        this.pathFilter = pathFilter;
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }
}
