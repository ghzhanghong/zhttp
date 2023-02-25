package com.zh.jm.http;

import java.util.List;

public class BaseListData<T>{
    public int curPage;
    public int pageCount;
    public int offset;
    public int size;
    public int total;
    public boolean over;
    public List<T> datas;
}
