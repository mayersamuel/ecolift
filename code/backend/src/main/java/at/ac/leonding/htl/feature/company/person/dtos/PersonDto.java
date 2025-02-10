package at.ac.leonding.htl.feature.company.person.dtos;

import at.ac.leonding.htl.feature.company.Company;

public record PersonDto(
        Long id,
        String name,
        Company company
) {
}
