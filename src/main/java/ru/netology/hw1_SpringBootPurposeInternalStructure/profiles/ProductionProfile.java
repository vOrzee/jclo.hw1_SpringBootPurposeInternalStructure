package ru.netology.hw1_SpringBootPurposeInternalStructure.profiles;

public class ProductionProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}