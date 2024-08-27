package dev.javarush.smia.licensing_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "licenses")
public final class License {
    @Id
    @Column(name = "license_id", nullable = false)
    private String licenseId;
    private String description;
    @Column(name = "organization_id", nullable = false)
    private String organizationId;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "license_type", nullable = false)
    private String licenseType;
    @Column(name = "comment")
    private String comment;

    public License(
            String licenseId,
            String description,
            String organizationId,
            String productName,
            String licenseType,
            String comment
    ) {
        this.licenseId = licenseId;
        this.description = description;
        this.organizationId = organizationId;
        this.productName = productName;
        this.licenseType = licenseType;
        this.comment = comment;
    }

    public License() {
    }

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

    public String getLicenseId() {
        return licenseId;
    }

    public String getDescription() {
        return description;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public String getProductName() {
        return productName;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (License) obj;
        return Objects.equals(this.licenseId, that.licenseId) &&
                Objects.equals(this.description, that.description) &&
                Objects.equals(this.organizationId, that.organizationId) &&
                Objects.equals(this.productName, that.productName) &&
                Objects.equals(this.licenseType, that.licenseType) &&
                Objects.equals(this.comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licenseId, description, organizationId, productName, licenseType, comment);
    }

    @Override
    public String toString() {
        return "License[" +
                "licenseId=" + licenseId + ", " +
                "description=" + description + ", " +
                "organizationId=" + organizationId + ", " +
                "productName=" + productName + ", " +
                "licenseType=" + licenseType + ", " +
                "comment=" + comment + ']';
    }

}