package dev.javarush.smia.smia_chapter4.controller;

import java.util.Locale;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.javarush.smia.smia_chapter4.model.License;
import dev.javarush.smia.smia_chapter4.service.LicenseService;

@RestController
@RequestMapping(value = "v1/organization/{organizationId}/license")
public class LicenseController {

    private final LicenseService licenseService;

    public LicenseController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @RequestMapping(value="/{licenseId}",method = RequestMethod.GET)
	public ResponseEntity<License> getLicense( @PathVariable("organizationId") String organizationId,
			@PathVariable("licenseId") String licenseId) {
		
		License license = licenseService.getLicense(licenseId, organizationId);
		return ResponseEntity.ok(license);
	}

	@PutMapping
	public ResponseEntity<String> updateLicense(@PathVariable("organizationId") String organizationId, @RequestBody License request,
        @RequestHeader(value = "Accept-Language",required = false) Locale locale) {
		return ResponseEntity.ok(licenseService.updateLicense(request, organizationId, locale));
	}

	@PostMapping
	public ResponseEntity<String> createLicense(@PathVariable("organizationId") String organizationId, @RequestBody License request,
			@RequestHeader(value = "Accept-Language",required = false) Locale locale) {
		return ResponseEntity.ok(licenseService.createLicense(request, organizationId, locale));
	}

	@DeleteMapping(value="/{licenseId}")
	public ResponseEntity<String> deleteLicense(@PathVariable("organizationId") String organizationId, @PathVariable("licenseId") String licenseId,
        @RequestHeader(value = "Accept-Language",required = false) Locale locale) {
		return ResponseEntity.ok(licenseService.deleteLicense(licenseId, organizationId, locale));
	}
    
}
