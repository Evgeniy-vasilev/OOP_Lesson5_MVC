package personal.views;

import personal.model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    Pattern namePattern = Pattern.compile("^\\S+$");
    Pattern phonePattern = Pattern.compile("^\\d+$");

    public void validateUser(User inputUser) throws Exception {
        Matcher nameMatcher = namePattern.matcher(inputUser.getFirstName());
        Matcher lastnameMatcher = namePattern.matcher(inputUser.getLastName());
        Matcher phoneMatcher = phonePattern.matcher(inputUser.getPhone());
        if (!nameMatcher.find()) {
            throw new Exception("Такое имя недопустимо!");
        }
        if (!lastnameMatcher.find()) {
            throw new Exception("Такая фамилия недопустима!");
        }
        if (!phoneMatcher.find()) {
            throw new Exception("Такой телефон недопустим!");
        }
    }
}
