package specialAnnotation;

import com.myApp.model.UserModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator  implements ConstraintValidator<PasswordMatches , UserModel> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserModel user, ConstraintValidatorContext constraintValidatorContext) {
        if (user.getPassword() == null || user.getConfirmPassword() == null) {
            return true;
        }

        boolean valid = user.getPassword().equals(user.getConfirmPassword());

        if (!valid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Passwords do not match")
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation();
        }

        return valid;
    }
}
