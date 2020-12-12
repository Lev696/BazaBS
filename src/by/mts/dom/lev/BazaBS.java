package by.mts.dom.lev;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BazaBS {

    public static void main(String[] args)  {
        int Num;
        String prog;
        String Obl;
        String ray;
        String adr;
        String constr;

        ArrayList<BaseStation> mtsBS = new ArrayList<>(); //создаем пустой список mtsBS с типом BaseStation ...

        Scanner in = new Scanner(System.in);
        while(true) {      // бесконечный цикл
            try {
                System.out.print("Ведите № БС: ");
                Num = in.nextInt();     // Ожидаем ввод СТРОКИ, пишем его в num
            } catch (InputMismatchException e) {
                System.out.println("Требуется целочисленный ввод, заново: ");
                Num=000;
            }
            in.nextLine();
            System.out.print("Ведите область: ");
            Obl = in.nextLine();     // Ожидаем ввод СТРОКИ, пишем его в obl
            System.out.print("Ведите район: ");
            ray = in.nextLine();     // Ожидаем ввод СТРОКИ, пишем его в ray
            System.out.print("Ведите адрес: ");
            adr = in.nextLine();     // Ожидаем ввод СТРОКИ, пишем его в adr
            System.out.print("Ведите тип конструкции: ");
            constr = in.nextLine();     // Ожидаем ввод СТРОКИ, пишем его в constr

            BaseStation ekzemplyar = new BaseStation(Num, Obl, ray, adr, constr); //создаем новый объект КЛАССА BaseStation с именем ekzemplyar
                                                                                  // и передаем параметры в конструктор
            mtsBS.add(ekzemplyar); // добавляем экземпляр объекта BaseStation с именем ekzemplyar в список (массив) mtsBS

            System.out.println("для прекращения ввода нажмите 'n'");
            prog = in.nextLine();
            if (prog.contains("n")) break; // Если в строке содержится "n" - выходим из цикла
        }
        in.close(); // закрываем поток поток ввода

        try {
            String bazaBS = "d:\\JAVA\\File_obmen\\test_papka\\bazaBS.txt"; //создаем наш файл для хранения данных
            // String bazaBS = "C:\\AllDostup\\SOFT\\JAVA\\ZDES\\NewFiles\\bazaBS.txt"; // создаем наш файл для хранения данных
            new File(bazaBS).getParentFile().mkdirs();
            FileWriter writer = new FileWriter(bazaBS);
            writer.write(mtsBS.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mtsBS.sort(Comparator.comparing(a -> a.number));
        printBaseStation(mtsBS);
        mtsBS.sort(Comparator.comparing(a -> a.konstrukciya));
        printBaseStation(mtsBS);
        mtsBS.sort(Comparator.comparing(a -> a.oblast));
        printBaseStation(mtsBS);
        mtsBS.sort(Comparator.comparing(a -> a.rayon));
        printBaseStation(mtsBS);
    }

    private static void printBaseStation(ArrayList<BaseStation> ArrayMTSBS) {

        // классический способ вывода списка:
        int i;
        for (i = 0; i < ArrayMTSBS.size(); i++) {
            System.out.print("№ БС: " + ArrayMTSBS.get(i).number);
            System.out.print("; Область: " + ArrayMTSBS.get(i).oblast);
            System.out.print("; Район: " + ArrayMTSBS.get(i).rayon);
            System.out.println("; Адрес = " + ArrayMTSBS.get(i).adres);
            System.out.println("; Конструкция = " + ArrayMTSBS.get(i).konstrukciya);
            System.out.println("");
        }
        System.out.println("------------------------------------");
    }
} // проверка скачивания с гита
