package data.info;

import SMExceptions.naming_exceptions.WrongInputException;

public class Gender extends Info {
    @Override
    protected boolean validate(CharSequence chars) throws WrongInputException {
        return chars.toString().compareToIgnoreCase("Male") == 0 || chars.toString().compareToIgnoreCase("Female") == 0;
    }
}