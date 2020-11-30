package com.example.session.chart;

import lombok.Data;


/**
 * @author Nate yu
 * @date 2020/11/10 - 15:58:48
 * @Description TODO
 */

@Data
public class Book{
    private static final long serialVersionUID = 1L;

    public Book(String id,String name){
        this.id = id;
        this.name = name;
    }

    private String id;
    private String name;
}
