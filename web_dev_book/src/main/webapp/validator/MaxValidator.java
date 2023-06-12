
package validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.hibernate.mapping.Property;

public class MaxValidator
        implements ConstraintValidator<Max, Object> {
    double max;

    //part of the Validator<Annotation> contract,
    //allows to get and use the annotation values
    public void initialize(Max parameters) {
        max = parameters.value();
    }

    //part of the property constraint contract
    public boolean isValid(Object value,
                           ConstraintValidatorContext constraintContext) {
        if (value==null) return true;
        if ( value instanceof Number) {
            double valueRead = ((Number) value).doubleValue();
            return valueRead <= max;
        }
        return false;
    }

    public void apply(Property arg0) {

    }
}
