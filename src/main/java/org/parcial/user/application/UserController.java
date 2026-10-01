package org.parcial.user.application;
import org.modelmapper.ModelMapper;
import org.parcial.product.dto.PagedResponseDto;
import org.parcial.user.domain.UserService;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelmapper;

    public ProductController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelmapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<PagedResponseDto<ProductDto>> getAllProducts(
            @PageableDefault(page = 0, size = 10) Pageable pageable) {

        Page<ProductDto> productsPage = userService.getAllProducts(pageable);
        PagedResponseDto<ProductDto> responseDto = new PagedResponseDto<>(productsPage);
        return ResponseEntity.ok(responseDto);
    }
}