package com.yaksha.training.blooddonors.service;

import com.yaksha.training.blooddonors.entity.Donor;
import com.yaksha.training.blooddonors.repository.DonorRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static com.yaksha.training.blooddonors.utils.MasterData.asJsonString;
import static com.yaksha.training.blooddonors.utils.MasterData.getDonor;
import static com.yaksha.training.blooddonors.utils.MasterData.getDonorList;
import static com.yaksha.training.blooddonors.utils.MasterData.randomStringWithSize;
import static com.yaksha.training.blooddonors.utils.TestUtils.businessTestFile;
import static com.yaksha.training.blooddonors.utils.TestUtils.currentTest;
import static com.yaksha.training.blooddonors.utils.TestUtils.testReport;
import static com.yaksha.training.blooddonors.utils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

public class DonorServiceTest {

    @Mock
    private DonorRepository donorRepository;

    @InjectMocks
    private DonorService donorService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void afterAll() {
        testReport();
    }

    @Test
    public void testServiceGetDonors() throws Exception {
        List<Donor> actual = getDonorList(5);
        when(donorRepository.findAll()).thenReturn(actual);
        List<Donor> expected = donorService.getDonors();
        yakshaAssert(currentTest(),
                (asJsonString(expected).equals(asJsonString(actual))
                        ? "true"
                        : "false"),
                businessTestFile);
    }

    @Test
    public void testServiceSaveDonor() throws Exception {
        Donor actual = getDonor();
        when(donorRepository.save(actual)).thenReturn(actual);
        Donor expected = donorService.saveDonor(actual);
        yakshaAssert(currentTest(),
                (asJsonString(expected).equals(asJsonString(actual))
                        ? "true"
                        : "false"),
                businessTestFile);
    }

    @Test
    public void testServiceGetDonor() throws Exception {
        Donor actual = getDonor();
        when(donorRepository.findById(actual.getId())).thenReturn(Optional.of(actual));
        Donor expected = donorService.getDonor(actual.getId());
        yakshaAssert(currentTest(),
                (asJsonString(expected).equals(asJsonString(actual))
                        ? "true"
                        : "false"),
                businessTestFile);
    }

    @Test
    public void testServiceDeleteDonor() throws Exception {
        Donor actual = getDonor();
        boolean expected = donorService.deleteDonor(actual.getId());
        yakshaAssert(currentTest(),
                (expected ? true : false),
                businessTestFile);
    }

}
