package ru.ifmo.cet.javabasics;

import java.util.HashMap;
import java.util.Map;

/**
 * Нужно реализовать констурктор и метод, возвращающий слова песни про бутылки на стене.
 * <p>
 * Слова следующие:
 * <p>
 * 99 bottles of beer on the wall, 99 bottles of beer
 * Take one down, pass it around, 98 bottles of beer
 * 98 bottles of beer on the wall, 98 bottles of beer
 * Take one down, pass it around, 97 bottles of beer
 * 97 bottles of beer on the wall, 97 bottles of beer
 * Take one down, pass it around, 96 bottles of beer
 * 96 bottles of beer on the wall, 96 bottles of beer
 * Take one down, pass it around, 95 bottles of beer
 * 95 bottles of beer on the wall, 95 bottles of beer
 * ...
 * <p>
 * 3 bottles of beer on the wall, 3 bottles of beer
 * Take one down, pass it around, 2 bottles of beer
 * 2 bottles of beer on the wall, 2 bottles of beer
 * Take one down, pass it around, 1 bottles of beer
 * 1 bottle of beer on the wall, 1 bottle of beer
 * Take one down, pass it around, no more bottles of beer on the wall
 * No more bottles of beer on the wall, no more bottles of beer
 * Go to the store and buy some more, 99 bottles of beer on the wall
 * <p>
 * Дело усложняется тем, что текст песни переменный:
 * За раз может быть взято несколько бутылок.
 * Значение передается в качестве параметра конструктора
 * Нужно ограничить возможность взятия бутылок натуральным число не более 99 бутылок за раз.
 */
public class BottleSong  {

    private Map<Integer, String> hashMap = new HashMap<Integer, String>();
    private int bottles = 99;
    private String song = "";

    public BottleSong(int bottleTakenAtOnce) {

        if(bottleTakenAtOnce > bottles || bottleTakenAtOnce <= 0) {
            throw new IllegalArgumentException("wrong number of bottles");
        }

        fullMap();

        writeSong(bottleTakenAtOnce, getTakenBottles(bottleTakenAtOnce));

    }

    private String getTakenBottles(int num){
        if(num >= 10) {
            if (num < 20) return hashMap.get(num);
            else if (num % 10 == 0)
                return hashMap.get(num);
            else
                return (hashMap.get(num - num % 10) + " " + hashMap.get(num % 10));
        }else return hashMap.get(num);

    }

    private void writeSong(int taken, String taken_word){


        while (bottles > 0){

            if(bottles > taken)
            {
                song += Integer.toString(bottles) + " " + (bottles == 1 ? "bottle" : "bottles") + " of beer on the wall, " +
                            Integer.toString(bottles) + " " + (bottles == 1 ? "bottle" : "bottles") + " of beer.\n" +
                            "Take " + taken_word + " down and pass around, " +
                            Integer.toString(bottles - taken) + " " + (bottles - taken == 1 ? "bottle" : "bottles") + " of beer on the wall.\n";
            }
            else
                {
                song += Integer.toString(bottles) + " " + (bottles == 1 ? "bottle" : "bottles") + " of beer on the wall, " +
                        Integer.toString(bottles) + " " + (bottles == 1 ? "bottle" : "bottles") + " of beer.\n" +
                        "Take " + getTakenBottles(bottles) +
                        " down and pass around, no more bottles of beer on the wall.\n";
                }
                bottles -= taken;
        }
        song += "No more bottles of beer on the wall, no more bottles of beer.\n" +
                "Go to the store and buy some more, 99 bottles of beer on the wall.\n";

    }

    private void fullMap(){
        hashMap.put(0,"");
        hashMap.put(1,"one");
        hashMap.put(2,"two");
        hashMap.put(3,"three");
        hashMap.put(4,"four");
        hashMap.put(5,"five");
        hashMap.put(6,"six");
        hashMap.put(7,"seven");
        hashMap.put(8,"eight");
        hashMap.put(9,"nine");
        hashMap.put(10,"ten");
        hashMap.put(11,"eleven");
        hashMap.put(12,"twelve");
        hashMap.put(13,"thirteen");
        hashMap.put(14,"fourteen");
        hashMap.put(15,"fifteen");
        hashMap.put(16,"sixteen");
        hashMap.put(17,"seventeen");
        hashMap.put(18,"eighteen");
        hashMap.put(19,"nineteen");
        hashMap.put(20,"twenty");
        hashMap.put(30,"thirty");
        hashMap.put(40,"forty");
        hashMap.put(50,"fifty");
        hashMap.put(60,"sixty");
        hashMap.put(70,"seventy");
        hashMap.put(80,"eighty");
        hashMap.put(90,"ninety");
    }

    public String getBottleSongLyrics() {
        return song;
    }
}
