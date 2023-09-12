public class Methods {
    public static boolean CheckNumberInWord(String word){
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetter(word.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static void CheckFormatDate(String word){
        if(word.length() != 10){
            throw new DateFormatException("ОШИБКА! Неверное количество символов!");
        }
        try {
            StringBuffer sb = new StringBuffer(word);
            StringBuffer sb1 = new StringBuffer(word);
            int day = Integer.parseInt(sb.delete(2,10).toString());
            if(day < 0 || day > 31){
                throw new  DateFormatException("ОШИБКА! День не может быть больше 31 и меньше 0");
            }
            int month = Integer.parseInt(sb1.substring(3,5));
            if(month < 0 || month > 12){
                throw new  DateFormatException("ОШИБКА! Месяц не может быть больше 12 и меньше 0");
            }
            int year = Integer.parseInt(sb1.substring(6,10));
            if(year < 1900 || year > 2023){
                throw new  DateFormatException("ОШИБКА! Год не может быть больше 2023 и меньше 1900");
            }
            if(word.charAt(2) != '.' || word.charAt(5) != '.' ){
                throw new  DateFormatException("Разделителем может быть только '.'");
            }
        } catch (NumberFormatException e){
            throw new  DateFormatException("ОШИБКА! День, месяц или год  - введены не цифры");
        }
    }
}
