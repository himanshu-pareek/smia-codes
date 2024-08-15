package dev.javarush.smia.smia_chapter4.model;

public record License(
    int id,
    String licenseId,
    String description,
    String organizationId,
    String productName,
    String licenseType
) {

    public License withOrganizationId(String orgId) {
        return new License(
            id,
            licenseId,
            description,
            orgId,
            productName,
            licenseType
        );
    }
}