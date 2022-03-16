package org.example;

import com.perscholas.controller.TheController;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TheController c = new TheController();
        c.createTables();
        c.insertRows();
    }
}
