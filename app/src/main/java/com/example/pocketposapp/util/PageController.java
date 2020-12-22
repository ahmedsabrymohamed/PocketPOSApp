package com.example.pocketposapp.util;


import com.example.pocketposapp.rest.api.responses.Page;

import java.util.HashMap;

public class PageController {
    public enum PagePosition {
        NEXT,CURRENT,PREVIOUS
    }
    private static HashMap<String, Page> pages = new HashMap<>();

    public static void initializeController(String [] collectionPages){
        for(String page: collectionPages)
            pages.put(page,new Page(-1));
    }
    private static Integer getNext(String collectionName){
        Page page= pages.get(collectionName);
        return page.getNumber()+1;
    }

    private static int getPrevious(String collectionName){
        Page page= pages.get(collectionName);
        return page.getNumber() < 1 ? null : page.getNumber()-1;
    }

    public static void setCurrentPage(String collectionName,Page page){
        pages.replace(collectionName,page);
    }

    public static Integer getPage(String collectionName, PagePosition pagePosition){
        if(PagePosition.NEXT == pagePosition)
            return getNext(collectionName);
        if(PagePosition.PREVIOUS == pagePosition)
            return getPrevious(collectionName);
        return pages.get(collectionName).getNumber();

    }
}
