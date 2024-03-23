package Domain;

import Exceptions.ExceptionInvalidValue;

public class Validate {
    public static boolean isLength(String str, int length) throws ExceptionInvalidValue  {
        if (str.length() != length) {
            throw new ExceptionInvalidValue(String.format("Недопустимая длина. Поле %s должно иметь %d символов.", str, length), new Exception());
        }
        return true;
    }

    public static boolean isLengthMin(String str, int length) throws ExceptionInvalidValue  {
        if (str.length() < length) {
            throw new ExceptionInvalidValue(String.format("Недопустимая длина. Поле %s должно иметь минимум %d символа.", str, length), new Exception());
        }
        return true;
    }
}
