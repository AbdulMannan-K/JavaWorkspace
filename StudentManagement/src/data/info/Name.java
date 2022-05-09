package data.info;

import SMExceptions.naming_exceptions.*;

public class Name extends Info {
    @Override
    protected boolean validate(CharSequence chars) throws WrongInputException {
        if (chars == null || chars.equals(""))
            throw new NothingFoundException("No Name was Detected");

        else if (isNumerical(chars)) {
            if (isSymbolical(chars))
                throw new NumberAndSymbolsFoundException("Number and symbols were found");
            else
                throw new NumbersFoundException("Number found");
        } else if (isSymbolical(chars)) {
            if (isNumerical(chars))
                throw new NumberAndSymbolsFoundException("Number and symbols were found");
            else
                throw new SymbolsFoundException("Symbol found");
        }

        return checkPunctuations(chars);
    }
}