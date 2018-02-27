package com.company.park_system.validator;

import com.company.park_system.entity.User;
import com.company.park_system.util.MessageManager;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class UserValidator implements Validator<User> {

    @Override
    public Map<String, String> validate(User user) {
        Map<String, String> errorMap = new HashMap<>();
        validateLogin(user.getLogin(), errorMap);
        validatePassword(user.getPassword(), errorMap);
        validateStatus(user.getStatus(), errorMap);
        return errorMap;
    }

    private void validateLogin(String login, Map<String, String> errorMap) {
        if (login == null) {
            errorMap.put("login", MessageManager.getProperty("user.login.empty"));
        } else if (contains(login, "\\s+")) {
            errorMap.put("login", MessageManager.getProperty("user.login.space"));
        } else if (login.length() < 5 || login.length() > 20) {
            errorMap.put("login", MessageManager.getProperty("user.login.size"));
        } else if (!login.matches("\\w+")) {
            errorMap.put("login", MessageManager.getProperty("user.login.format"));
        }
    }

    private void validatePassword(String password, Map<String, String> errorMap) {
        if (password == null) {
            errorMap.put("password", MessageManager.getProperty("user.password.empty"));
        } else if (contains(password, "\\s+")) {
            errorMap.put("password", MessageManager.getProperty("user.password.space"));
        } else if (password.length() < 6 || password.length() > 15) {
            errorMap.put("password", MessageManager.getProperty("user.password.size"));
        } else if (!contains(password, "[0-9]+") || !contains(password, "[a-zA-Z]+")) {
            errorMap.put("password", MessageManager.getProperty("user.password.format"));
        }
    }

    private void validateStatus(String status, Map<String, String> errorMap) {
        if (status == null) {
            errorMap.put("status", MessageManager.getProperty("user.status.empty"));
        } else if (!status.equals("owner") && !status.equals("forester")) {
            errorMap.put("status", MessageManager.getProperty("user.status.incorrect"));
        }
    }

    private boolean contains(String string, String regex) {
        return Pattern.compile(regex).matcher(string).find();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> errorMap = new HashMap<>();
        UserValidator validator = new UserValidator();
//        while (true) {
//            System.out.println("Enter password: ");
//            String status = reader.readLine();
//            validator.validatePassword(status, errorMap);
//            System.out.println(errorMap.get("password"));
//            errorMap.clear();
//        }
//        while (true) {
//            System.out.println("Enter login: ");
//            String login = reader.readLine();
//            validator.validateLogin(login, errorMap);
//            System.out.println(errorMap.get("login"));
//            errorMap.clear();
//        }
        while (true) {
            System.out.println("Enter status: ");
            String status = reader.readLine();
            validator.validateStatus(status, errorMap);
            System.out.println(errorMap.get("status"));
            errorMap.clear();
        }
    }
}
