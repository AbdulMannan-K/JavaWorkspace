package data.info;

import SMExceptions.naming_exceptions.*;

public class EMail extends Info {

    @Override
    protected boolean validate(CharSequence chars) throws WrongInputException {
        String str = chars.toString();
        if(!str.contains("@") || !str.contains(".com"))
            throw new WrongInputException("Invalid Email");
        try {
            checkPunctuations(str.split("@")[0]);
        } catch(WrongInputException wie) {
            throw new WrongInputException("Invalid Email");
        }
        if (str.split("@")[0].endsWith("."))
            throw new WrongInputException("Invalid Email");
        str = str.split("@")[1].split(".com")[0];
        if(isSymbolical(str))
            throw new WrongInputException("Invalid Email");
        return true;
    }
}