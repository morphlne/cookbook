package io.pan.cookbook.validation.validator;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@ExtendWith(SpringExtension.class)
@Import(LocalValidatorFactoryBean.class)
public class ValidatorTest {

    @Autowired
    private Validator validator;

    protected BeanPropertyBindingResult validationResult(Object target) {
        var result = new BeanPropertyBindingResult(target, "ignored");
        validator.validate(target, result);
        return result;
    }

}
