package data.info;

import SMExceptions.naming_exceptions.*;
import utilities.StringUtilities;

public class Details extends Info {
    @Override
    protected boolean validate(CharSequence chars) throws SymbolsFoundException, IllegalUseOfPunctuation {
        return StringUtilities.checkPunctuations(chars);
    }
}