package org.parcial.store.domain;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.parcial.user.domain.User;

@Setter
@Getter
@NoArgsConstructor
public class Store {
    @Id
    @NotEmpty
    String id;
    @NotEmpty
    String name;
    @NotEmpty
    User ownerId;
    String location;
    String status;
}
