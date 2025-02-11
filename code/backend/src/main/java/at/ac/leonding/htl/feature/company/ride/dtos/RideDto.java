package at.ac.leonding.htl.feature.company.ride.dtos;

import at.ac.leonding.htl.feature.company.person.dtos.PersonDto;

public record RideDto(
    Long id,
    String startDestination,
    String targetDestination,
    PersonDto host
) {
}
