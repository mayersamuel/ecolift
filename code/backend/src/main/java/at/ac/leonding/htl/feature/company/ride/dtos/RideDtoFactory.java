package at.ac.leonding.htl.feature.company.ride.dtos;

import at.ac.leonding.htl.feature.company.person.dtos.PersonDtoFactory;
import at.ac.leonding.htl.feature.company.ride.Ride;

import java.util.List;

public class RideDtoFactory {
    public static RideDto create(Ride ride) {
        return new RideDto(
                ride.id,
                ride.startDestination,
                ride.targetDestination,
                PersonDtoFactory.create(ride.host)
        );
    }

    public static List<RideDto> createList(List<Ride> rides) {
        return rides.stream().map(RideDtoFactory::create).toList();
    }
}
