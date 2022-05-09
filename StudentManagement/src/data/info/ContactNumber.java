package data.info;

import SMExceptions.naming_exceptions.*;

public class ContactNumber extends Info {

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
        }
        else if(chars.length() < 10) {
            throw new WrongInputException("Less numbers found.");
        } else if (chars.length() > 13) {
            throw new WrongInputException("Invalid Number too much characters.");
        } else {
            if(chars.length() == 13 || chars.length() == 12)
                if(!chars.toString().contains("+92"))
                    throw new WrongInputException("Number is Invalid");
        }
        if(isPunctuational(chars)) {
            throw new PunctuationsFoundException();
        }
        return true;
    }
}
