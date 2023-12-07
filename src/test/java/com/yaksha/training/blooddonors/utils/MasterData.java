package com.yaksha.training.blooddonors.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.yaksha.training.blooddonors.entity.Donor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MasterData {

    private static Random rnd = new Random();

    public static Donor getDonor() {
        Donor donor = new Donor();
        donor.setId(1L);
        donor.setFirstName(randomStringWithSize(10));
        donor.setLastName(randomStringWithSize(10));
        donor.setEmail(randomStringWithSize(20) + "@gmail.com");
        donor.setMobileNumber(randomNumberWithSize(10));
        donor.setState(randomNumberWithSize(5));
        donor.setCity(randomNumberWithSize(5));
        return donor;
    }

    public static List<Donor> getDonorList(int size) {
        Long id = 0L;
        List<Donor> donors = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Donor donor = new Donor();
            donor.setId(++id);
            donor.setFirstName(randomStringWithSize(10));
            donor.setLastName(randomStringWithSize(10));
            donor.setEmail(randomStringWithSize(20) + "@gmail.com");
            donor.setMobileNumber(randomNumberWithSize(10));
            donor.setState(randomNumberWithSize(5));
            donor.setCity(randomNumberWithSize(5));
            donors.add(donor);
        }
        return donors;
    }

    public static String randomStringWithSize(int size) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        String s = "";
        for (int i = 0; i < size; i++) {
            s = s + (String.valueOf(alphabet.charAt(rnd.nextInt(alphabet.length()))));
        }
        return s;
    }

    public static String randomNumberWithSize(int size) {
        String alphabet = "1234567890";
        Random rnd = new Random();
        String s = "";
        for (int i = 0; i < size; i++) {
            s = s + (String.valueOf(alphabet.charAt(rnd.nextInt(alphabet.length()))));
        }
        return s;
    }

    public static boolean randomBoolean() {
        String alphabet = "1234567890";
        Random rnd = new Random();
        return rnd.nextInt(alphabet.length()) % 2 == 0;
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            final String jsonContent = mapper.writeValueAsString(obj);

            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
