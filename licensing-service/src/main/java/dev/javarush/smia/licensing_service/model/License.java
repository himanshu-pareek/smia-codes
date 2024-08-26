package dev.javarush.smia.licensing_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "licenses")
public record License(
        @Id @Column(name = "license_id", nullable = false) String licenseId,
        String description,
        @Column(name = "organization_id", nullable = false) String organizationId,
        @Column(name = "product_name", nullable = false) String productName,
        @Column(name = "license_type", nullable = false) String licenseType,
        @Column(name = "comment") String comment
) {

    public License withOrganizationId(String orgId) {
        return new License(
                licenseId,
                description,
                orgId,
                productName,
                licenseType,
                comment
        );
    }

    public License withComment(String comment) {
        return new License(
                licenseId,
                description,
                organizationId,
                productName,
                licenseType,
                comment
        );
    }

    public License withRandomUUID() {
        return new License(
                UUID.randomUUID().toString(),
                description,
                organizationId,
                productName,
                licenseType,
                comment
        );
    }
}