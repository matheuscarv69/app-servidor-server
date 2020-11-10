package io.github.matheuscarv69.validation.constraintValidation;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import io.github.matheuscarv69.validation.NotEmptyBoolean;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Null;
import java.lang.annotation.Annotation;

public class NotEmptyBooleanValidator implements
        ConstraintValidator<NotEmptyBoolean, Boolean>{

    private boolean value;

    @Override
    public void initialize(NotEmptyBoolean constraintAnnotation) {

    }

    @Override
    public boolean isValid(Boolean aBoolean,
                           ConstraintValidatorContext constraintValidatorContext) {

        if(aBoolean == null){
            return true;
        }

        return false;
    }

}
