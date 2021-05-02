package com.xpr.excel;

import java.util.Set;

public class WorkbookData {

    private String sheetName;
    private String[] headers;
    private Set<Object[]> data;

    public WorkbookData() {
    }

    public WorkbookData(String sheetName) {
        this.sheetName = sheetName;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public String[] getHeaders() {
        return headers;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }

    public Set<Object[]> getData() {
        return data;
    }

    public void setData(Set<Object[]> data) {
        this.data = data;
    }
}
