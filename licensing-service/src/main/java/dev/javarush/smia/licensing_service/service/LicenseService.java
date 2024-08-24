package dev.javarush.smia.licensing_service.service;

import java.util.Locale;
import java.util.Random;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import dev.javarush.smia.licensing_service.model.License;;

@Service
public class LicenseService {

    private final MessageSource messageSource;

    public LicenseService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public License getLicense(String licenseId, String organizationId) {
        return new License(
            new Random().nextInt(1000),
            licenseId,
            "Software Product",
            organizationId,
            "Ostock",
            "Full"
        );
    }

    public String createLicense(License license, String organizationId, Locale locale) {
        if (license != null) {
            license = license.withOrganizationId(organizationId);
            return messageSource.getMessage(
                "license.create.message",
                new Object[]{license.toString()},
                locale
            );
        }
        return null;
    }

    public String updateLicense(License license, String organizationId, Locale locale) {
        if (license != null) {
            license = license.withOrganizationId(organizationId);
            return messageSource.getMessage(
                "license.update.message",
                new Object[]{license.toString()},
                locale
            );
        }
        return null;
    }
    
    public String deleteLicense(String licenseId, String organizationId, Locale locale) {
        return messageSource.getMessage(
            "license.delete.message",
            new Object[]{licenseId, organizationId},
            locale
        );
    }
}
