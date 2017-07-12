package com.hexagon.clinic.dao;

public class OrderStruct {

    private String rawOrder;
    private String pathOrder;
    private Boolean descOrder;

    public OrderStruct(String orderString) {

        if (orderString == null)
            return;

        this.rawOrder = orderString;

        if (orderString.charAt(0) == '-') {
            descOrder = true;
            pathOrder = orderString.substring(1);
        } else {
            descOrder = false;
            pathOrder = orderString;
        }
    }

    public String getRawOrder() {
        return rawOrder;
    }

    public void setRawOrder(String rawOrder) {
        this.rawOrder = rawOrder;
    }

    public String getPathOrder() {
        return pathOrder;
    }

    public void setPathOrder(String pathOrder) {
        this.pathOrder = pathOrder;
    }

    public Boolean getDescOrder() {
        return descOrder;
    }

    public void setDescOrder(Boolean descOrder) {
        this.descOrder = descOrder;
    }


}
