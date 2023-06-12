
package shared;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Min;
import org.hibernate.mapping.Property;

public class MinValidator
        implements ConstraintValidator<Min, Object>  {
    double min;

    //part of the Validator<Annotation> contract,
    //allows to get and use the annotation values
    public void initialize(Min parameters) {
        min = parameters.value();
    }

    //part of the property constraint contract
    public boolean isValid(Object value,
                           ConstraintValidatorContext constraintContext) {
        if (value==null) return true;
        if ( value instanceof Number) {
            double valueRead = ((Number) value).doubleValue();
            return valueRead >= min;
        }
        return false;
    }

    public void apply(Property arg0) {

    }
}
