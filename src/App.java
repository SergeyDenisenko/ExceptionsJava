import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Exceptions.ExceptionIncompleteData;
import Exceptions.ExceptionInvalidValue;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные разделяя пробелом.");
        System.out.println("Фамилия Имя Отчество дата_рождения номер_телефона пол:");
        String str = scanner.nextLine();

        String[] data;
        String surname;
        String name;
        String midle_name;
        String birthdate;
        String phone_number;
        char gender;

        try {
            data = str.split(" ");
        } catch (Exception e) {
            throw new ExceptionIncompleteData("Введены неполные данные.", e);
        }

        try {
            surname = data[0];
            name = data[1];
            midle_name = data[2];
            birthdate = data[3];
            phone_number = data[4];
            gender = data[5].charAt(0);
        } catch (Exception e) {
            throw new ExceptionIncompleteData("Введены неполные данные.", e);
        }

        if (surname.length() < 2) {
            throw new ExceptionInvalidValue("Введено некорректное значение", new Exception());
        }

        if (name.length() < 2) {
            throw new ExceptionInvalidValue("Введено некорректное значение", new Exception());
        }

        if (midle_name.length() < 2) {
            throw new ExceptionInvalidValue("Введено некорректное значение", new Exception());
        }

        if (birthdate.length() != 10) {
            throw new ExceptionInvalidValue("Введено некорректное значение", new Exception());
        }

        if (phone_number.length() < 3) {
            throw new ExceptionInvalidValue("Введено некорректное значение", new Exception());
        }

        String[] date;
        try {
            date = birthdate.split("\\.");
        } catch (Exception e) {
            throw new ExceptionIncompleteData("Введены неполные данные.", e);
        }

        int day;
        int month;
        int year;

        if (date[0].length() != 2) {
            throw new ExceptionIncompleteData("Введены неполные данные.", new Exception());
        }

        if (date[1].length() != 2) {
            throw new ExceptionIncompleteData("Введены неполные данные.", new Exception());
        }

        if (date[2].length() != 4) {
            throw new ExceptionIncompleteData("Введены неполные данные.", new Exception());
        }

        try {
            day = Integer.parseInt(date[0]);
            month = Integer.parseInt(date[1]);
            year = Integer.parseInt(date[2]);
        } catch (Exception e) {
            throw new ExceptionInvalidValue("Введено некорректное значение", e);
        }

        Long phone;
        try {
            phone = Math.abs(Long.parseLong(phone_number));
        } catch (Exception e) {
            throw new ExceptionInvalidValue("Введено некорректное значение", e);
        }

        System.out.println(gender);
        if (!(gender == 'm' || gender == 'f')) {
            throw new ExceptionInvalidValue("Введено некорректное значение", new Exception());
        }

        String file = surname+".txt";
        try (FileWriter fw = new FileWriter(file, true)) {
            String line = String.format("<%s> <%s> <%s> <%s> <%d> <%s>\n", surname, name, midle_name, birthdate, phone, gender);
            fw.write(line);
            fw.flush();
        } catch (IOException e) {
            System.out.println("Write error!");
        }
    }
}
