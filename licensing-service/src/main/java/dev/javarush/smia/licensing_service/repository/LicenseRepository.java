package dev.javarush.smia.licensing_service.repository;

import dev.javarush.smia.licensing_service.model.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface LicenseRepository extends CrudRepository<License, String> {

    Stream<License> findAllByOrganizationId(String organizationId);

    Optional<License> findByOrganizationIdAndLicenseId(String organizationId, String licenseId);

}
