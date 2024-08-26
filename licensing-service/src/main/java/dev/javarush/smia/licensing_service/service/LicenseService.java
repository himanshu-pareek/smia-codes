package dev.javarush.smia.licensing_service.service;

import java.util.Locale;
import java.util.Random;

import dev.javarush.smia.licensing_service.config.ServiceConfig;
import dev.javarush.smia.licensing_service.repository.LicenseRepository;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import dev.javarush.smia.licensing_service.model.License;;

@Service
public class LicenseService {

    private final MessageSource messageSource;
    private final LicenseRepository licenseRepository;
    private final ServiceConfig serviceConfig;

    public LicenseService(MessageSource messageSource, LicenseRepository licenseRepository, ServiceConfig serviceConfig) {
        this.messageSource = messageSource;
        this.licenseRepository = licenseRepository;
        this.serviceConfig = serviceConfig;
    }

    public License getLicense(String licenseId, String organizationId) {
        return licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId)
                .orElseThrow(() -> new IllegalArgumentException(
                        messageSource.getMessage(
                                "license.search.error.message",
                                new Object[]{licenseId, organizationId},
                                Locale.getDefault())
                ))
                .withComment(this.serviceConfig.getProperty());
    }

    public License createLicense(License license, String organizationId) {
        license = license.withOrganizationId(organizationId).withComment(this.serviceConfig.getProperty()).withRandomUUID();
        license = licenseRepository.save(license);
        return license;
    }

    public License updateLicense(License license) {
        license = licenseRepository.save(license.withComment(serviceConfig.getProperty()));
        return license;
    }
    
    public String deleteLicense(String licenseId) {
        licenseRepository.deleteById(licenseId);
        return messageSource.getMessage(
            "license.delete.message",
            new Object[]{licenseId},
            Locale.getDefault()
        );
    }
}
