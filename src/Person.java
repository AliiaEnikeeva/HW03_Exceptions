import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Person {
        private String name;
        private String surname;
        private String patronymic;
        private String birthday;
        private long phone_number;
        private String sex;
        private String fullInformation;
        private Scanner scanner = new Scanner(System.in);

        public Person() {
            inputSurname();
            inputName();
            inputPatronymic();
            inputBirthday();
            inputPhone();
            inputSex();
            fullInformation = surname + " " + name + " " + patronymic + " " + phone_number + " " + sex;
            try(FileWriter in = new FileWriter(surname, true)) {

                in.append(fullInformation + "\n");
            }catch (IOException e){
                throw new RuntimeException("Проблемы с записью файла");
            }
        }

        public void inputName(){
            System.out.println("Введите имя:");
            name = scanner.next();
            if(Methods.CheckNumberInWord(name)){
                throw new PersonNameException("Неверный формат! Имя должно состоять только из букв");
            }
        }
        public void inputSurname(){
            System.out.println("Введите фамилию:");
            surname = scanner.next();
            if(Methods.CheckNumberInWord(surname)){
                throw new PersonNameException("Неверный формат! Фамилия должна состоять только из букв");
            }
        }
        public void inputPatronymic(){
            System.out.println("Введите отчество:");
            patronymic = scanner.next();
            if(Methods.CheckNumberInWord(patronymic)){
                throw new PersonNameException("Неверный формат! Отчество должно состоять только из букв");
            }
        }
        public void inputBirthday(){
            System.out.println("Введите день рождения в формате дд.мм.гггг:");
            birthday = scanner.next();
            Methods.CheckFormatDate(birthday);
        }
        public void inputPhone(){
            System.out.println("Введите номер телефона:");
            try {
                phone_number = scanner.nextInt();
            } catch (NumberFormatException e) {
                throw new PhoneNumberException("Неверный формат! Телефон, может состоять только из цифр");
            }
            catch (InputMismatchException e){
                throw new PhoneNumberException("Неверный формат! Телефон, может состоять только из цифр");
            }

        }
        public void inputSex(){
            System.out.println("Введите пол (f - женский, m - мужской):");
            sex = scanner.next();
            if(!sex.equals("f") && !sex.equals("m")){
                throw new SexException("Неверное значение! Пол может быть только f - женский, m - мужской");
            }
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public String getPatronymic() {
            return patronymic;
        }

        public String getBirthday() {
            return birthday;
        }

        public long getPhone() {
            return phone_number;
        }

        public String getSex() {
            return sex;
        }

        @Override
        public String toString() {
            return fullInformation;
        }

}
