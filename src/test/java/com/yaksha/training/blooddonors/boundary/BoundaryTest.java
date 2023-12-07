package com.yaksha.training.blooddonors.boundary;


import com.yaksha.training.blooddonors.entity.Donor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static com.yaksha.training.blooddonors.utils.MasterData.getDonor;
import static com.yaksha.training.blooddonors.utils.MasterData.randomStringWithSize;
import static com.yaksha.training.blooddonors.utils.TestUtils.boundaryTestFile;
import static com.yaksha.training.blooddonors.utils.TestUtils.currentTest;
import static com.yaksha.training.blooddonors.utils.TestUtils.testReport;
import static com.yaksha.training.blooddonors.utils.TestUtils.yakshaAssert;

@ExtendWith(SpringExtension.class)
public class BoundaryTest {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @AfterAll
    public static void afterAll() {
        testReport();
    }

    @Test
    public void testFirstNameNotBlank() throws Exception {
        Donor donor = getDonor();
        donor.setFirstName("");
        Set<ConstraintViolation<Donor>> violations = validator.validate(donor);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testFirstNameNotNull() throws Exception {
        Donor donor = getDonor();
        donor.setFirstName(null);
        Set<ConstraintViolation<Donor>> violations = validator.validate(donor);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testFirstNameMinTwo() throws Exception {
        Donor donor = getDonor();
        donor.setFirstName(randomStringWithSize(1));
        Set<ConstraintViolation<Donor>> violations = validator.validate(donor);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testFirstNameMaxForty() throws Exception {
        Donor donor = getDonor();
        donor.setFirstName(randomStringWithSize(41));
        Set<ConstraintViolation<Donor>> violations = validator.validate(donor);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testLastNameNotBlank() throws Exception {
        Donor donor = getDonor();
        donor.setLastName("");
        Set<ConstraintViolation<Donor>> violations = validator.validate(donor);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testLastNameNotNull() throws Exception {
        Donor donor = getDonor();
        donor.setLastName(null);
        Set<ConstraintViolation<Donor>> violations = validator.validate(donor);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testLastNameMinTwo() throws Exception {
        Donor donor = getDonor();
        donor.setLastName(randomStringWithSize(1));
        Set<ConstraintViolation<Donor>> violations = validator.validate(donor);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testLastNameMaxFourty() throws Exception {
        Donor donor = getDonor();
        donor.setLastName(randomStringWithSize(41));
        Set<ConstraintViolation<Donor>> violations = validator.validate(donor);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testEmailNotBlank() throws Exception {
        Donor donor = getDonor();
        donor.setEmail("");
        Set<ConstraintViolation<Donor>> violations = validator.validate(donor);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testEmailNotNull() throws Exception {
        Donor donor = getDonor();
        donor.setEmail(null);
        Set<ConstraintViolation<Donor>> violations = validator.validate(donor);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testEmailInvalidFormat() throws Exception {
        Donor donor = getDonor();
        donor.setEmail(randomStringWithSize(10));
        Set<ConstraintViolation<Donor>> violations = validator.validate(donor);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testMobileNumberNotBlank() throws Exception {
        Donor donor = getDonor();
        donor.setMobileNumber("");
        Set<ConstraintViolation<Donor>> violations = validator.validate(donor);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testMobileNumberNotNull() throws Exception {
        Donor donor = getDonor();
        donor.setMobileNumber(null);
        Set<ConstraintViolation<Donor>> violations = validator.validate(donor);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testMobileNumberInvalidFormat() throws Exception {
        Donor donor = getDonor();
        donor.setMobileNumber(randomStringWithSize(10));
        Set<ConstraintViolation<Donor>> violations = validator.validate(donor);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testStateNotBlank() throws Exception {
        Donor donor = getDonor();
        donor.setState("");
        Set<ConstraintViolation<Donor>> violations = validator.validate(donor);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testStateNotNull() throws Exception {
        Donor donor = getDonor();
        donor.setState(null);
        Set<ConstraintViolation<Donor>> violations = validator.validate(donor);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testCityNotBlank() throws Exception {
        Donor donor = getDonor();
        donor.setCity("");
        Set<ConstraintViolation<Donor>> violations = validator.validate(donor);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

    @Test
    public void testCityNotNull() throws Exception {
        Donor donor = getDonor();
        donor.setCity(null);
        Set<ConstraintViolation<Donor>> violations = validator.validate(donor);
        yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
    }

}
