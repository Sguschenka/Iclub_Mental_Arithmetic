package ru.erp.mental_arithmetic;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



import java.util.Random;
import java.util.logging.LogRecord;

import static java.lang.Math.pow;


public class Arithmetics {

    public static int[] intervalArray = {85, 50, 25, 29};
    public static int[] numbersArray = {4, 8, 10, 3};
    public static int[] numbersLengthArray = {1, 3, 3, 3};
    public static boolean[] negativesArray = {false, true, true, false};

  //  public int interval = 1; // временной промежуток между числами

//    public int numbers = 5; // количество чисел максимум - 30

//    public int numberLength = 2; // длина одного числа

//    public boolean negatives = false; // есть ли отрицательные числа (true - есть; false - нет)

    public static int numberRandom; // генерируемое рандомное число

    public static int numberSum; // Сумма чисел

    public static int coint; // баллы за одну игру

    public static int cointSum = 0; // = 10; // сумма баллов

    final static Random random = new Random();
    private SharedPreferences sPref;
    final String cointS = "saved_sum";

    public static final String APP_PREFERENCES = "score";
    public static final String APP_PREFERENCES_COUNTER = "counter";
    private SharedPreferences mScore;


    static int a = 0;



    public static void GenerateNumbers(int level) {
        if (negativesArray[level]) {                                             // генерит отрицательные числа
            do {
                int maxNumber = 2 * (int) pow(10, numbersLengthArray[level]);
                numberRandom = (random.nextInt(maxNumber) - maxNumber / 2);
            }while (numberRandom == 0);

        } else {
                int maxNumber = (int) pow(10, numbersLengthArray[level]) - 1;   // генерит положительные числа
                numberRandom = random.nextInt(maxNumber) + 1;
        }
    }



    static int[] Numb = new int[30];



    static public void SumNumbers(final int level) { // создает новые числа, выводит их на экран и считает их сумму

        int maxNumber =   (int) pow(10, numbersLengthArray[level]);
        Numb[0] = (random.nextInt(maxNumber/2) + maxNumber/2);// первое число всегда лежит в диапозоне от половины максимума до максимума
        numberSum = Numb[0];
       a = Numb[0];
        for (int i = 1; i < numbersArray[level]; i++) {            // Второе число
            if (i == 1){                                           // всегда меньше первого по модулю
                while (Numb[0] <= a) {                   //
                    Arithmetics.GenerateNumbers(level);            //
                    a = numberRandom;
                }
            } else {                                              // со следующими числами нет заморочек, но их сумма должна быть положительной
                do {
                    Arithmetics.GenerateNumbers(level);

                } while ((numberSum + numberRandom) <= 0); // Сумма должна быть больше нуля. Об этом говорилось выше :)
            }


            Numb[i] = numberRandom;
            numberSum += numberRandom;
        }

    }

    protected static void cointPoints(int level){ // считает количество баллов за одну игру
        int negativesValue = 1;
        if (negativesArray[level]){ negativesValue = 2;}
        coint = (100/intervalArray[level])*numbersArray[level]*numbersLengthArray[level]*negativesValue;
        if(coint == 0) {
         coint = 1;
        }
        cointSum += coint;
    }









    // Рабочий класс. Он генерирует числа и запоминает их сумму. С помощью магической формулы подсчитывает количество баллов(Формула есть. Ехуууу). Еще выводит их кол-во на экран
    // Три метода: создание чисел и вывод их на экран, подсчет баллов, настройка параметров (sumNumbers, cointPoints, settingLevel) ;)
    // Еще его можно настроить с помощью настроек (которых еще нет. ха-ха.)
    // Метод работы с числами: есть цикл с счетчиком, значение которого зависит от настроек. Есть таймер. Цифры выводятся и исчезают. Особая переменная тем временем считает их сумму и хранит ее.
    // НУЖЕН МЕТОДЫ СОХРАНЕНИЯ И ЗАГРУЗКИ ДАННЫХ ИЗ ФАЙЛА. СОХРАНЕНИЕ = ИЗМЕНЕНИЕ В НАСТРОЙКАХ.

}
