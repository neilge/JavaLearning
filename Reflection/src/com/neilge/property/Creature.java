package com.neilge.property;

import java.io.Serializable;

/**
 * @author Neo
 * @since 09/17/2020-9:59 PM
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath() {
        System.out.println("生物呼吸");
    }

    public void eat() {
        System.out.println("生物吃东西");
    }
}
