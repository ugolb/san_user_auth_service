package com.san.auth.services.dao;

import com.san.auth.models.UserAuthModel;
import com.san.auth.services.dto.UserDtlsDto;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

@Component
public class UserAuthDaoFileImpl implements UserAuthDao {
    private static final String SEPARATOR = "|";
    private final File userDataStore = new File("./" + "UserDataStore.txt");

    @Override
    public boolean userIsNotExist(String email) {

        return readDataStoreFile().contains(email);
    }

    @Override
    public UserDtlsDto saveUserRegistrationData(final UserAuthModel userAuthModel) {
        if(userIsNotExist(userAuthModel.getEmail())){
            throw new IllegalArgumentException("User already exist");
        }
        return writeToFileUserData(createFileDataStoreIfNotExist(), userAuthModel);
    }

    @Override
    public UserDtlsDto loginUser(UserAuthModel userAuthModel) {
        if(!userIsNotExist(userAuthModel.getEmail()) && !userIsNotExist(userAuthModel.getPassword())){
            throw new IllegalArgumentException("User does not exist");
        }
        return UserDtlsDto.builder()
                .userName(userAuthModel.getUserName())
                .userId(111L)
                .build();
    }

    private List<String> readDataStoreFile(){
        try {
            return Files.readAllLines(Paths.get(userDataStore.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private UserDtlsDto writeToFileUserData(final File userDataStore, final UserAuthModel userAuthModel) {
        try (Writer output = new BufferedWriter(new FileWriter(userDataStore.getPath(), true))) {
            output.append("\n" + getConcatenatedUserAuthString(userAuthModel));
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return UserDtlsDto.builder()
                .userId(111L)
                .userName(userAuthModel.getUserName())
                .build();
    }

    private String getConcatenatedUserAuthString(UserAuthModel userAuthModel) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder concatenatedString = stringBuilder
                .append("111")
                .append(SEPARATOR)
                .append(userAuthModel.getUserName())
                .append(SEPARATOR)
                .append(userAuthModel.getEmail())
                .append(SEPARATOR)
                .append(userAuthModel.getPassword());
        return new String(concatenatedString);
    }

    private File createFileDataStoreIfNotExist() {
        try {
            userDataStore.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userDataStore;
    }
}
