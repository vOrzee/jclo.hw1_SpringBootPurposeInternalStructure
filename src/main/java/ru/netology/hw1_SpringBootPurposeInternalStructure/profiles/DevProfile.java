package ru.netology.hw1_SpringBootPurposeInternalStructure.profiles;

public class DevProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}
