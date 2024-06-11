import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {


        Scanner in = new Scanner(System.in);
        System.out.print("Введите через пробел Фамилия Имя Отчество дата _ рождения номер _ телефона пол - m или f ");

        String dataString = in.nextLine();

        String[] data = dataString.split(" ");

        if (data.length > 6)
            throw new FormatExeptionPlus();
        if (data.length < 6)
            throw new FormatExeptionMinus();



        String family_name = data[0];
        String name = data[1];
        String father_name = data[2];
        String birth_date = data[3];
        String phoneNumber = data[4];
        String gender = data[5];
        String full_name = family_name + name + father_name;

        boolean matches = Pattern.matches("^[а-яА-Я ]+$", full_name);


        if (!matches)
            throw new nameChecker();

        //if(containLetters(data[0])){
        //throw new IOException("Вы ввели неправильную фамилию.");
        //if (containLetters(data[1]))
        //throw new IOException("Вы ввели неправильное имя.");
//
//        if(containLetters(data[2]))
//            throw new IOException("Вы ввели неправильное отчество.");
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String birthDate = String.valueOf(simpleDateFormat.parse(data[3]));
        } catch (ParseException e) {
            System.out.println("Вы неправильно ввели дату своего рождения.");
            return;
        }

        try {
            long telephoneNumber = Long.parseLong(data[4]);
        } catch (NumberFormatException g) {
            System.out.println("Вы неправильно ввели свой номер телефона.");
            return;
        }

        if (!data[5].equals("m") && !data[5].equals("f"))
            throw new IOException("Введите m, если Вы мужчина, и f, если Вы женщина.");

        //String family_name = data[0];
        try {
            File file = new File(String.format("%s", family_name, true));
            if (file.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("Файл уже существует");

            }
        } catch (IOException e) {
            System.out.println("Поскольку файл с таким названием уже существует," +
                    " мы запишем Вас в него отдельной строкой");
        }

        try {
            FileWriter fileWriter = new FileWriter(family_name, true);
            fileWriter.write(dataString + "\n");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//    public static boolean containLetters(String string) {
//        return Pattern.matches("[а-яА-ЯёЁ] + ", string);
//    }


    }}







