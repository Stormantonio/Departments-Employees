package com.chernenko.controller.abstractFactory;

import com.chernenko.controller.MainController;

/**
 * Created by Anton on 15.04.2017.
 */
public abstract class AbstractFactory {

    public abstract MainController getController(String url);
}
