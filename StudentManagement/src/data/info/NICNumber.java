package data.info;

import SMExceptions.naming_exceptions.*;

public class NICNumber extends Info {
    @Override
    protected boolean validate(CharSequence chars) throws WrongInputException {
        if(chars == null || chars.equals(""))
            throw new NothingFoundException();

        else if (isSymbolical(chars)) {
            if (isAlphabetical(chars))
                throw new AlphabetsAndSymbolsFoundException();
            else
                throw new SymbolsFoundException();
        } else if (isAlphabetical(chars)) {
            if (isSymbolical(chars))
                throw new AlphabetsAndSymbolsFoundException();
            else
                throw new AlphabetsFoundException();
        } else if(chars.length() != 13) {
            throw new WrongInputException("Not Valid less Characters found.");
        }

        if(isPunctuational(chars)) {
            throw new PunctuationsFoundException();
        }

        return true;
    }
}