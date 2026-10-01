package org.parcial.user.domain;

import org.modelmapper.ModelMapper;
import org.parcial.user.dto.PagedResponseDto;
import org.parcial.user.dto.UserRegisterDto;
import org.parcial.user.infrastructure.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public Page<PagedResponseDto> getAllProducts(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User convertirDtoAEntidad(UserRegisterDto registroDTO) {
        User user = modelMapper.map(registroDTO, User.class);
        return user;
    }

}