/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author LinhDzai
 */
public class InfoBasicDB {

    private String nameTable;
    private String colName;
    private String dataType;
    private int maxLength;

    public String getNameTable() {
        return nameTable;
    }

    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public InfoBasicDB() {
    }

    public InfoBasicDB(String nameTable, String colName, String dataType, int maxLength) {
        this.nameTable = nameTable;
        this.colName = colName;
        this.dataType = dataType;
        this.maxLength = maxLength;
    }
    public Object[] toArray(){
        return new Object[]{
            nameTable,colName,dataType,maxLength
        };
    }
}
