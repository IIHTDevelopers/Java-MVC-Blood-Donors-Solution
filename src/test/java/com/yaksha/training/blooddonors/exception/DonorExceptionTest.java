package com.yaksha.training.blooddonors.exception;

import com.yaksha.training.blooddonors.controller.DonorController;
import com.yaksha.training.blooddonors.entity.Donor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;

import static com.yaksha.training.blooddonors.utils.MasterData.getDonor;
import static com.yaksha.training.blooddonors.utils.MasterData.randomStringWithSize;
import static com.yaksha.training.blooddonors.utils.TestUtils.currentTest;
import static com.yaksha.training.blooddonors.utils.TestUtils.exceptionTestFile;
import static com.yaksha.training.blooddonors.utils.TestUtils.testReport;
import static com.yaksha.training.blooddonors.utils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class DonorExceptionTest {

    @InjectMocks
    private DonorController donorController;

    private MockMvc mockMvc;

    BindingResult bindingResult = mock(BindingResult.class);

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(donorController).build();
    }

    @After
    public void afterAll() {
        testReport();
    }

    @Test
    public void testExceptionSaveDonorFirstNameAsNull() throws Exception {
        Donor donor = getDonor();
        donor.setId(null);
        donor.setFirstName(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveDonor")
                .flashAttr("donor", donor)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-donor-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionSaveDonorLastNameAsNull() throws Exception {
        Donor donor = getDonor();
        donor.setId(null);
        donor.setLastName(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveDonor")
                .flashAttr("donor", donor)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-donor-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionSaveDonorEmailAsNull() throws Exception {
        Donor donor = getDonor();
        donor.setId(null);
        donor.setEmail(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveDonor")
                .flashAttr("donor", donor)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-donor-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionSaveDonorEmailInvalidFormat() throws Exception {
        Donor donor = getDonor();
        donor.setId(null);
        donor.setEmail(randomStringWithSize(10));
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveDonor")
                .flashAttr("donor", donor)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-donor-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionSaveDonorMobileNumberAsNull() throws Exception {
        Donor donor = getDonor();
        donor.setId(null);
        donor.setMobileNumber(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveDonor")
                .flashAttr("donor", donor)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-donor-form")), exceptionTestFile);
    }


    @Test
    public void testExceptionSaveDonorMobileNumberInvalidFormat() throws Exception {
        Donor donor = getDonor();
        donor.setId(null);
        donor.setMobileNumber(randomStringWithSize(10));
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveDonor")
                .flashAttr("donor", donor)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("add-donor-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionUpdateDonorFirstNameAsNull() throws Exception {
        Donor donor = getDonor();

        donor.setFirstName(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveDonor")
                .flashAttr("donor", donor)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-donor-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionUpdateDonorLastNameAsNull() throws Exception {
        Donor donor = getDonor();

        donor.setLastName(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveDonor")
                .flashAttr("donor", donor)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-donor-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionUpdateDonorEmailAsNull() throws Exception {
        Donor donor = getDonor();

        donor.setEmail(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveDonor")
                .flashAttr("donor", donor)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-donor-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionUpdateDonorEmailInvalidFormat() throws Exception {
        Donor donor = getDonor();

        donor.setEmail(randomStringWithSize(10));
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveDonor")
                .flashAttr("donor", donor)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-donor-form")), exceptionTestFile);
    }

    @Test
    public void testExceptionUpdateDonorMobileNumberAsNull() throws Exception {
        Donor donor = getDonor();

        donor.setMobileNumber(null);
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveDonor")
                .flashAttr("donor", donor)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-donor-form")), exceptionTestFile);
    }


    @Test
    public void testExceptionUpdateDonorMobileNumberInvalidFormat() throws Exception {
        Donor donor = getDonor();

        donor.setMobileNumber(randomStringWithSize(10));
        when(bindingResult.hasErrors()).thenReturn(true);
        MvcResult result = this.mockMvc.perform(post("/saveDonor")
                .flashAttr("donor", donor)).andReturn();
        yakshaAssert(currentTest(), (result.getModelAndView() != null
                && result.getModelAndView().getViewName() != null
                && result.getModelAndView().getViewName().contentEquals("update-donor-form")), exceptionTestFile);
    }
}
